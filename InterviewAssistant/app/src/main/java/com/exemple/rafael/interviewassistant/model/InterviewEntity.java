package com.exemple.rafael.interviewassistant.model;

import android.content.ContentValues;
import android.content.Context;

/**
 * Created by Rafael on 19/01/2017.
 */

public class InterviewEntity extends GenericEntity<Interview> {
    public static final String NOME_TABELA              = "TbInterview";
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

    public InterviewEntity(Context context) {
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
    public ContentValues entidadeParacontentValues(Interview entidade) {
        ContentValues values = new ContentValues();
        values.put(COLUNA_ID				    , entidade.getId());
        values.put(COLUNA_IDPERSON			    , entidade.isIdPerson());
        values.put(COLUNA_VIEWERFOUND		    , entidade.isViewerAccept());
        values.put(COLUNA_VIEWERACCEPT		    , entidade.isViewerAccept());
        values.put(COLUNA_USESUS			    , entidade.isUseSus());
        values.put(COLUNA_IDPROCEDURE		    , entidade.isIdProcedure());
        values.put(COLUNA_PROCEDUREHOSPITAL     , entidade.isProcedureHospital());
        values.put(COLUNA_IDHOSPITAL		    , entidade.isIDHospital());
        values.put(COLUNA_OTHERHOSPITAL		    , entidade.isOtherHospital());
        values.put(COLUNA_USEMEDICALPLAN	    , entidade.isUseMedicalPlan());
        values.put(COLUNA_IDPROBLEMWITHPLAN     , entidade.isIDProblemWithPlan());
        values.put(COLUNA_IDSICKNESS		    , entidade.isIDSickness());
        values.put(COLUNA_NEEDGETBETTER 	    , entidade.getNeedGetBetter());
        values.put(COLUNA_QUALITYOFSUS		    , entidade.isQualityOfSus());
        values.put(COLUNA_OTHERIMPROVEMENT	    , entidade.isOtherImprovement());
        values.put(COLUNA_IDOCUPATION		    , entidade.isIDOcupation());
        values.put(COLUNA_OTHEROCUPATION	    , entidade.isOtherOcupation());
        values.put(COLUNA_DEGREESCHOOL		    , entidade.isDegreeSchool());
        values.put(COLUNA_LIVEWITH			    , entidade.isLiveWith());
        values.put(COLUNA_OTHERDWELLER		    , entidade.isOtherDweller());
        values.put(COLUNA_HASCHILDREN		    , entidade.isHasChildren());
        values.put(COLUNA_RELIGION			    , entidade.isReligion());
        values.put(COLUNA_ABOUTELECTION		    , entidade.isAboutElection());
        values.put(COLUNA_WILLVOTE			    , entidade.isWillVote());
        values.put(COLUNA_HOWSELECTCANDIDATE    , entidade.isHowSelectCandidate());
        values.put(COLUNA_WHATTHEYDO		    , entidade.isWhatTheyDo());
        values.put(COLUNA_DESCRIBEPOLITICJOB    , entidade.isDescribePoliticJob());
        values.put(COLUNA_KNOWSUPERSIMPLES	    , entidade.isKnowSuperSimples());
        values.put(COLUNA_FUNCAPOSENTADO	    , entidade.isFuncAposentado());
        values.put(COLUNA_APOSENTADA		    , entidade.isAposentada());
        values.put(COLUNA_MOTIVODESEMPREGO	    , entidade.isMotivoDesemprego());
        values.put(COLUNA_DESEMSELEC		    , entidade.isDesemSelec());
        values.put(COLUNA_RESPDESEMPENHO	    , entidade.isRespDesempenho());
        values.put(COLUNA_OTHERRESP			    , entidade.isOtherResp());
        return values;
    }

    @Override
    public Interview contentValuesParaEntidade(ContentValues contentValues) {
        Interview interview = new Interview();
        interview.setId(contentValues.getAsInteger(COLUNA_ID));
        interview.setIdPerson(contentValues.getAsInteger(COLUNA_IDPERSON));
        interview.setViewerFound(contentValues.getAsBoolean(COLUNA_VIEWERFOUND));
        interview.setViewerAccept(contentValues.getAsBoolean(COLUNA_VIEWERACCEPT));
        interview.setUseSus(contentValues.getAsBoolean(COLUNA_USESUS));
        interview.setIdProcedure(contentValues.getAsShort(COLUNA_IDPROCEDURE));
        interview.setProcedureHospital(contentValues.getAsBoolean(COLUNA_PROCEDUREHOSPITAL));
        interview.setIDHospital(contentValues.getAsShort(COLUNA_IDHOSPITAL));
        interview.setOtherHospital(contentValues.getAsString(COLUNA_OTHERHOSPITAL));
        interview.setUseMedicalPlan(contentValues.getAsBoolean(COLUNA_USEMEDICALPLAN));
        interview.setIDProblemWithPlan(contentValues.getAsShort(COLUNA_IDPROBLEMWITHPLAN));
        interview.setIDSickness(contentValues.getAsShort(COLUNA_IDSICKNESS));
        interview.setNeedGetBetter(contentValues.getAsShort(COLUNA_NEEDGETBETTER));
        interview.setQualityOfSus(contentValues.getAsShort(COLUNA_QUALITYOFSUS));
        interview.setOtherImprovement(contentValues.getAsString(COLUNA_OTHERIMPROVEMENT));
        interview.setIDOcupation(contentValues.getAsShort(COLUNA_IDOCUPATION));
        interview.setOtherOcupation(contentValues.getAsString(COLUNA_OTHEROCUPATION));
        interview.setDegreeSchool(contentValues.getAsShort(COLUNA_DEGREESCHOOL));
        interview.setLiveWith(contentValues.getAsShort(COLUNA_LIVEWITH));
        interview.setOtherDweller(contentValues.getAsString(COLUNA_OTHERDWELLER));
        interview.setHasChildren(contentValues.getAsBoolean(COLUNA_HASCHILDREN));
        interview.setReligion(contentValues.getAsShort(COLUNA_RELIGION));
        interview.setAboutElection(contentValues.getAsShort(COLUNA_ABOUTELECTION));
        interview.setWillVote(contentValues.getAsBoolean(COLUNA_WILLVOTE));
        interview.setHowSelectCandidate(contentValues.getAsShort(COLUNA_HOWSELECTCANDIDATE));
        interview.setWhatTheyDo(contentValues.getAsBoolean(COLUNA_WHATTHEYDO));
        interview.setDescribePoliticJob(contentValues.getAsShort(COLUNA_DESCRIBEPOLITICJOB));
        interview.setKnowSuperSimples(contentValues.getAsBoolean(COLUNA_KNOWSUPERSIMPLES));
        interview.setFuncAposentado(contentValues.getAsBoolean(COLUNA_FUNCAPOSENTADO));
        interview.setAposentada(contentValues.getAsBoolean(COLUNA_APOSENTADA));
        interview.setMotivoDesemprego(contentValues.getAsShort(COLUNA_MOTIVODESEMPREGO));
        interview.setDesemSelec(contentValues.getAsShort(COLUNA_DESEMSELEC));
        interview.setRespDesempenho(contentValues.getAsShort(COLUNA_RESPDESEMPENHO));
        interview.setOtherResp(contentValues.getAsString(COLUNA_OTHERRESP));
        return interview;

    }
    private static InterviewEntity instance;

    public static InterviewEntity getInstance(Context context) {
        if(instance == null)
            instance = new InterviewEntity(context);
        return instance;
    }

}
