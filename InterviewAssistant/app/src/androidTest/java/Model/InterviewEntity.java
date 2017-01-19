package Model;

import android.content.ContentValues;

/**
 * Created by Rafael on 19/01/2017.
 */

public class InterviewEntity extends GenericEntity {
    public static final String NOME_TABELA = "TbInterview";
    public static final String COLUNA_ID				= "id";
    public static final String COLUNA_IDPERSON			= "idPerson";
    public static final String COLUNA_VIEWERFOUND		= "viewerFound";
    public static final String COLUNA_VIEWERACCEPT		= "viewerAccept";
    public static final String COLUNA_USESUS			= "useSus";
    public static final String COLUNA_IDPROCEDURE		= "idProcedure";
    public static final String COLUNA_PROCEDUREHOSPITAL = "procedureHospital";
    public static final String COLUNA_IDHOSPITAL		= "IDHospital";
    public static final String COLUNA_OTHERHOSPITAL		= "otherHospital";
    public static final String COLUNA_USEMEDICALPLAN	= "useMedicalPlan";
    public static final String COLUNA_IDPROBLEMWITHPLAN = "IDProblemWithPlan";
    public static final String COLUNA_IDSICKNESS		= "IDSickness";
    public static final String COLUNA_NEEDGETBETTER 	= "needGetBetter";
    public static final String COLUNA_QUALITYOFSUS		= "qualityOfSus";
    public static final String COLUNA_OTHERIMPROVEMENT	= "otherImprovement";
    public static final String COLUNA_IDOCUPATION		= "IDOcupation";
    public static final String COLUNA_OTHEROCUPATION	= "otherOcupation";
    public static final String COLUNA_DEGREESCHOOL		= "degreeSchool";
    public static final String COLUNA_LIVEWITH			= "liveWith";
    public static final String COLUNA_OTHERDWELLER		= "otherDweller";
    public static final String COLUNA_HASCHILDREN		= "hasChildren";
    public static final String COLUNA_RELIGION			= "religion";
    public static final String COLUNA_ABOUTELECTION		= "aboutElection";
    public static final String COLUNA_WILLVOTE			= "willVote";
    public static final String COLUNA_HOWSELECTCANDIDATE= "howSelectCandidate";
    public static final String COLUNA_WHATTHEYDO		= "whatTheyDo";
    public static final String COLUNA_DESCRIBEPOLITICJOB= "describePoliticJob";
    public static final String COLUNA_KNOWSUPERSIMPLES	= "knowSuperSimples";
    public static final String COLUNA_FUNCAPOSENTADO	= "funcAposentado";
    public static final String COLUNA_APOSENTADA		= "aposentada";
    public static final String COLUNA_MOTIVODESEMPREGO	= "motivoDesemprego";
    public static final String COLUNA_DESEMSELEC		= "desemSelec";
    public static final String COLUNA_RESPDESEMPENHO	= "respDesempenho";
    public static final String COLUNA_OTHERRESP			= "otherResp";

    public static final String SCRIPT_CREATE_PERSON = "CREATE TABLE " + NOME_TABELA + "("
            + COLUNA_ID + " INTEGER PRIMARY KEY," + COLUNA_IDPERSON + " INTEGER," + COLUNA_VIEWERFOUND + " INTEGER,"
            + COLUNA_VIEWERACCEPT + " INTEGER," + COLUNA_USESUS + " INTEGER"
            + COLUNA_IDPROCEDURE + " INTEGER," + COLUNA_PROCEDUREHOSPITAL + " INTEGER"
            + COLUNA_IDHOSPITAL + " INTEGER," + COLUNA_OTHERHOSPITAL + " TEXT"
            + COLUNA_USEMEDICALPLAN + " INTEGER," + COLUNA_IDPROBLEMWITHPLAN + " INTEGER"
            + COLUNA_IDSICKNESS + " INTEGER," + COLUNA_NEEDGETBETTER + " INTEGER"
            + COLUNA_QUALITYOFSUS + " INTEGER," + COLUNA_OTHERIMPROVEMENT + " TEXT"
            + COLUNA_IDOCUPATION + " INTEGER," + COLUNA_OTHEROCUPATION + " TEXT"
            + COLUNA_DEGREESCHOOL + " INTEGER," + COLUNA_LIVEWITH + " INTEGER"
            + COLUNA_OTHERDWELLER + " TEXT," + COLUNA_HASCHILDREN + " INTEGER"
            + COLUNA_RELIGION + " INTEGER," + COLUNA_ABOUTELECTION + " INTEGER"
            + COLUNA_WILLVOTE + " INTEGER," + COLUNA_HOWSELECTCANDIDATE + " INTEGER"
            + COLUNA_WHATTHEYDO + " INTEGER," + COLUNA_DESCRIBEPOLITICJOB + " INTEGER"
            + COLUNA_KNOWSUPERSIMPLES + " INTEGER," + COLUNA_FUNCAPOSENTADO + " INTEGER"
            + COLUNA_APOSENTADA + " INTEGER," + COLUNA_MOTIVODESEMPREGO + " INTEGER"
            + COLUNA_DESEMSELEC + " INTEGER," + COLUNA_RESPDESEMPENHO + " INTEGER"
            + COLUNA_OTHERRESP + " TEXT"+
            "FOREIGN KEY("+COLUNA_IDPERSON+") REFERENCES TbPerson(id)"+
            ")";

    public static final String SCRIPT_DELECAO_TABELA =  "DROP TABLE IF EXISTS " + NOME_TABELA;

    @Override
    public String getNomeColunaPrimaryKey() {
        return COLUNA_ID;
    }

    @Override
    public String getNomeTabela() {
        return null;
    }

    @Override
    public ContentValues entidadeParacontentValues(IPersistentEntity entidade) {
        return null;
    }

    @Override
    public IPersistentEntity contentValuesParaEntidade(ContentValues contentValues) {
        return null;
    }
}
