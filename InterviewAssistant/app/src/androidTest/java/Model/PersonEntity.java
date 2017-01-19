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

public class PersonEntity {
    public static final String NOME_TABELA = "TbPerson";
    public static final String COLUNA_ID = "id";
    public static final String COLUNA_POSTCODE = "postcode";
    public static final String COLUNA_NUMBER = "number";
    public static final String COLUNA_NAME = "name";
    public static final String COLUNA_CELLFPHONE = "cellphone";

    public static final String SCRIPT_CRIACAO_TABELA_personS = "CREATE TABLE " + NOME_TABELA + "("
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
        PersistenceHelper persistenceHelper = PersistenceHelper.getInstance(context);
        dataBase = persistenceHelper.getWritableDatabase();
    }

    public void Save(Person person) {
        ContentValues values = gerarContentValeuesPerson(person);
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
        ContentValues valores = gerarContentValeuesPerson(person);

        String[] valoresParaSubstituir = {
                String.valueOf(person.getId())
        };

        dataBase.update(NOME_TABELA, valores, COLUNA_ID + " = ?", valoresParaSubstituir);
    }

    private ContentValues gerarContentValeuesPerson(Person person) {
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
                    int indexMarca = cursor.getColumnIndex(COLUNA_MARCA);
                    int indexModelo = cursor.getColumnIndex(COLUNA_MODELO);
                    int indexPlaca = cursor.getColumnIndex(COLUNA_PLACA);

                    int id = cursor.getInt(indexID);
                    String marca = cursor.getString(indexMarca);
                    String modelo = cursor.getString(indexModelo);
                    String placa = cursor.getString(indexPlaca);

                    person person = new person(id, marca, modelo, placa);

                    persons.add(person);

                } while (cursor.moveToNext());
            }

        } finally {
            cursor.close();
        }
        return persons;
    }

    private ContentValues gerarContentValeuesperson(person person) {
        ContentValues values = new ContentValues();
        values.put(COLUNA_MARCA, person.getMarca());
        values.put(COLUNA_MODELO, person.getModelo());
        values.put(COLUNA_PLACA, person.getPlaca());

        return values;
    }

}
