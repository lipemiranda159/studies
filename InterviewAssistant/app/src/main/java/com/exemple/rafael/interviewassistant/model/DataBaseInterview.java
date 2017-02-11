package com.exemple.rafael.interviewassistant.model;

import android.content.Intent;

import java.util.List;

/**
 * Created by Rafael on 30/01/2017.
 */

public class DataBaseInterview {
    private final InterviewDao interviewDao;
    private final InterviewedPersonDao interviewedPersonDao;

    public DataBaseInterview(DaoSession daoSession)
    {

        interviewDao = daoSession.getInterviewDao();
        interviewedPersonDao = daoSession.getInterviewedPersonDao();

    }

    public void insert(Long IdPerson,String name, Interview interview, Intent intent)
    {
        //interviewDao.deleteAll();
        interviewDao.insert(interview);
        intent.putExtra("Id", IdPerson);
        intent.putExtra("Name", name);

    }

    public void updateDb(Long IdPerson,String name, Interview interview, Intent intent)
    {
        Interview oldInterview = interviewDao.queryRaw("WHERE id_Person ="+1).get(0);
        oldInterview = CopyData(oldInterview,interview);
        interviewDao.update(oldInterview);
        intent.putExtra("Id", IdPerson);
        intent.putExtra("Name", name);

    }

    public List<InterviewedPerson> getInterviewedPerson(String postCode, short Number)
    {

        return interviewedPersonDao.queryRaw("WHERE post_code ='"+postCode+"' AND number ="+Number);
    }

    private Interview CopyData(Interview interviewSource, Interview interviewDestination)
    {
        /*
        int id = interviewSource.getId();
        if (id != interviewDestination.getId())
        {
            interviewDestination.setId(id);
        }


        int idPerson = interviewSource.isIdPerson();
        if (idPerson != interviewDestination.isIdPerson()){
            interviewDestination.setIdPerson(idPerson);
        }*/
        String dateStart = interviewSource.getDateStart();
        if (!dateStart.contains(interviewDestination.getDateStart()))
        {
            interviewDestination.setDateStart(dateStart);
        }
        String dateFinish = interviewDestination.getDateFinish();
        if (!dateFinish.contains(interviewDestination.getDateFinish())){
            interviewDestination.setDateFinish(dateFinish);
        }

        boolean viewerFound = interviewSource.viewerFound;
        if (viewerFound != interviewDestination.viewerFound){
            interviewDestination.viewerFound = viewerFound;
        }
        boolean viewerAccept = interviewSource.viewerAccept;
        if (viewerAccept != interviewDestination.viewerAccept){
            interviewDestination.viewerAccept = viewerAccept;
        }
        boolean useSus = interviewSource.useSus;
        if (useSus != interviewDestination.useSus)
        {
            interviewDestination.useSus = useSus;
        }
        short idProcedure = interviewSource.idProcedure;
        if (idProcedure != interviewDestination.idProcedure){
            interviewDestination.idProcedure = idProcedure;
        }
        boolean procedureHospital = interviewSource.procedureHospital;
        if (procedureHospital != interviewDestination.procedureHospital)
        {
            interviewDestination.procedureHospital = procedureHospital;
        }
        short IDHospital = interviewSource.IDHospital;
        if (IDHospital != interviewDestination.IDHospital){
            interviewDestination.IDHospital = IDHospital;
        }
        String otherHospital = interviewSource.otherHospital;
        if (otherHospital.contains(interviewDestination.otherHospital)){
            interviewDestination.otherHospital = otherHospital;
        }
        boolean useMedicalPlan = interviewSource.useMedicalPlan;
        if (useMedicalPlan != interviewDestination.useMedicalPlan){
            interviewDestination.useMedicalPlan = useMedicalPlan;
        }
        short IDProblemWithPlan = interviewSource.IDProblemWithPlan;
        if (IDProblemWithPlan != interviewDestination.IDProblemWithPlan){
            interviewDestination.IDProblemWithPlan = IDProblemWithPlan;
        }
        short IDSickness = interviewSource.IDSickness;
        if (IDSickness != interviewDestination.IDSickness){
            interviewDestination.IDSickness = IDSickness;
        }
        short needGetBetter = interviewSource.needGetBetter;
        if (needGetBetter != interviewDestination.needGetBetter){
            interviewDestination.needGetBetter = needGetBetter;
        }
        short qualityOfSus = interviewSource.qualityOfSus;
        if (qualityOfSus != interviewDestination.qualityOfSus){
            interviewDestination.qualityOfSus = qualityOfSus;
        }
        String otherImprovement = interviewSource.otherImprovement;
        if (!otherImprovement.contains(interviewDestination.otherImprovement)){
            interviewDestination.otherImprovement = otherImprovement;
        }
        short IDOcupation = interviewSource.IDOcupation;
        if (IDOcupation != interviewDestination.IDOcupation){
            interviewDestination.IDOcupation = IDOcupation;
        }
        String otherOcupation = interviewSource.otherOcupation;
        if (!otherOcupation.contains(interviewDestination.otherOcupation)){
            interviewDestination.otherOcupation = otherOcupation;
        }
        short degreeSchool = interviewSource.degreeSchool;
        if (degreeSchool != interviewDestination.degreeSchool){
            interviewDestination.degreeSchool = degreeSchool;
        }
        short liveWith = interviewSource.liveWith;
        if (liveWith != interviewDestination.liveWith){
            interviewDestination.liveWith = liveWith;
        }
        String otherDweller = interviewSource.otherDweller;
        if (!otherDweller.contains(interviewDestination.otherDweller)){
            interviewDestination.otherDweller = otherDweller;
        }
        boolean hasChildren = interviewSource.hasChildren;
        if (hasChildren != interviewDestination.hasChildren){
            interviewDestination.hasChildren = hasChildren;
        }
        short religion = interviewSource.religion;
        if (religion != interviewDestination.religion){
            interviewDestination.religion = religion;
        }
        short aboutElection = interviewSource.aboutElection;
        if (aboutElection != interviewDestination.aboutElection){
            interviewDestination.aboutElection = aboutElection;
        }
        boolean willVote = interviewSource.willVote;
        if (willVote != interviewDestination.willVote) {
            interviewDestination.willVote = willVote;
        }
        short howSelectCandidate = interviewSource.howSelectCandidate;
        if (howSelectCandidate != interviewDestination.howSelectCandidate){
            interviewDestination.howSelectCandidate = howSelectCandidate;
        }
        boolean whatTheyDo = interviewSource.whatTheyDo;
        if (whatTheyDo != interviewDestination.whatTheyDo){
            interviewDestination.whatTheyDo = whatTheyDo;
        }
        short describePoliticJob = interviewSource.describePoliticJob;
        if (describePoliticJob != interviewDestination.describePoliticJob){
            interviewDestination.describePoliticJob = describePoliticJob;
        }
        boolean knowSuperSimples = interviewSource.knowSuperSimples;
        if (knowSuperSimples != interviewDestination.knowSuperSimples){
            interviewDestination.knowSuperSimples = knowSuperSimples;
        }
        boolean funcAposentado = interviewSource.funcAposentado;
        if (funcAposentado != interviewDestination.funcAposentado){
            interviewDestination.funcAposentado = funcAposentado;
        }
        boolean aposentada = interviewSource.aposentada;
        if (aposentada != interviewDestination.aposentada){
            interviewDestination.aposentada = aposentada;
        }
        short motivoDesemprego = interviewSource.motivoDesemprego;
        if (motivoDesemprego != interviewDestination.motivoDesemprego){
            interviewDestination.motivoDesemprego = motivoDesemprego;
        }
        short desemSelec = interviewSource.desemSelec;
        if (desemSelec != interviewDestination.desemSelec){
            interviewDestination.desemSelec = desemSelec;
        }
        short respDesempenho = interviewSource.respDesempenho;
        if (respDesempenho != interviewDestination.respDesempenho){
            interviewDestination.respDesempenho = respDesempenho;
        }
        return interviewDestination;
    }

    public  void deleteInterview()
    {
        interviewDao.deleteAll();

    }
}
