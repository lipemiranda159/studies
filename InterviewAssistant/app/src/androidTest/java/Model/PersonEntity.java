package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 19/01/2017.
 */

public class PersonEntity extends GenericEntity<Person> {
    public static final String NOME_TABELA = "TbPerson";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_POSTCODE = "postcode";
    public static final String COLUNA_NUMBER = "number";
    public static final String COLUNA_NAME = "name";
    public static final String COLUNA_CELLFPHONE = "cellphone";

    public static final String SCRIPT_CREATE_PERSON = "CREATE TABLE " + NOME_TABELA + "("
            + COLUNA_ID + " INTEGER PRIMARY KEY," + COLUNA_POSTCODE + " TEXT," + COLUNA_NUMBER + " INTEGER,"
            + COLUNA_NAME + " TEXT," + COLUNA_CELLFPHONE + " TEXT"  + ")";

    public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;


    private SQLiteDatabase dataBase = null;


    private static PersonEntity instance;

    public static PersonEntity getInstance(Context context) {
        if(instance == null)
            instance = new PersonEntity(context);
        return instance;
    }

    private PersonEntity(Context context) {
        super(context);
        PersistenceHelper persistenceHelper = PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }

    @Override
    public String getNomeColunaPrimaryKey() {
        return COLUNA_ID;
    }

    @Override
    public String getNomeTabela() {
        return NOME_TABELA;
    }

    @Override
    public ContentValues entidadeParacontentValues(Person entidade) {

        ContentValues values = new ContentValues();
        values.put(COLUNA_POSTCODE, entidade.getPostCode());
        values.put(COLUNA_NUMBER, entidade.getNumber());
        values.put(COLUNA_NAME, entidade.getName());
        values.put(COLUNA_CELLFPHONE, entidade.getCellPhone());
        return values;    }

    @Override
    public Person contentValuesParaEntidade(ContentValues contentValues) {
        Person pessoa = new Person();
        pessoa.setId(contentValues.getAsInteger(COLUNA_ID));
        pessoa.setPostCode(contentValues.getAsString(COLUNA_POSTCODE));
        pessoa.setNumber(contentValues.getAsShort(COLUNA_NUMBER));
        pessoa.setName(contentValues.getAsString(COLUNA_NAME));
        pessoa.setCellPhone(contentValues.getAsString(COLUNA_CELLFPHONE));
        return pessoa;
    }

    public void Save(Person person) {
        ContentValues values = entidadeParacontentValues(person);
        dataBase.insert(NOME_TABELA, null, values);
    }

    public List<Person> GetAll() {
        String queryReturnAll = "SELECT * FROM " + NOME_TABELA;
        Cursor cursor = dataBase.rawQuery(queryReturnAll, null);
        List<Person> personEntitys = construirpersonPorCursor(cursor);

        return personEntitys;
    }

    public void delete(Person person) {

        String[] valoresParaSubstituir = {
                String.valueOf(person.getId())
        };

        dataBase.delete(NOME_TABELA, COLUNA_ID + " =  ?", valoresParaSubstituir);
    }

    public void update(Person person) {
        ContentValues valores = entidadeParacontentValues(person);

        String[] valoresParaSubstituir = {
                String.valueOf(person.getId())
        };

        dataBase.update(NOME_TABELA, valores, COLUNA_ID + " = ?", valoresParaSubstituir);
    }

    public void closeConnection() {
        if(dataBase != null && dataBase.isOpen())
            dataBase.close();
    }


    private List<Person> construirpersonPorCursor(Cursor cursor) {
        List<Person> persons = new ArrayList<Person>();
        if(cursor == null)
            return persons;

        try {

            if (cursor.moveToFirst()) {
                do {

                    int indexID = cursor.getColumnIndex(COLUNA_ID);
                    int indexPostCode = cursor.getColumnIndex(COLUNA_POSTCODE);
                    int indexNumber = cursor.getColumnIndex(COLUNA_NUMBER);
                    int indexName = cursor.getColumnIndex(COLUNA_NAME);
                    int indexCellphone = cursor.getColumnIndex(COLUNA_CELLFPHONE);

                    int id = cursor.getInt(indexID);
                    String postCode = cursor.getString(indexPostCode);
                    String number = cursor.getString(indexNumber);
                    String name = cursor.getString(indexName);
                    String cellPhone = cursor.getString(indexCellphone);

                    Person person = new Person(id, postCode, number, name, cellPhone);

                    persons.add(person);

                } while (cursor.moveToNext());
            }

        } finally {
            cursor.close();
        }
        return persons;
    }

}
