package com.exemple.rafael.interviewassistant.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;

import java.io.Serializable;
import java.util.Date;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by Rafael on 19/01/2017.
 */
@Entity(indexes = {
        @Index(value = "id, idPerson", unique = true)
})
public class Interview  {
    @Id
    Long id;
    @NotNull
    Long idPerson;


    public void setInterviewSent(boolean interviewSent) {
        this.interviewSent = interviewSent;
    }

    public boolean interviewSent;


    public void setVerifyAge(boolean verifyAge) {
        this.verifyAge = verifyAge;
    }

    public boolean verifyAge;

    public Interview(){
        this.id = Long.valueOf(0);
        this.idPerson = Long.valueOf(0);
        this.dateStart = "";
        this.dateFinish = "";
        this.verifyAge = false;
        this.viewerFound = false;
        this.viewerAccept = false;
        this.useSus = false;
        this.idProcedure = 0;
        this.procedureHospital = false;
        this.IDHospital = 0;
        this.otherHospital = "";
        this.useMedicalPlan = false;
        this.IDProblemWithPlan = 0;
        this.IDSickness = 0;
        this.needGetBetter = 0;
        this.qualityOfSus = 0;
        this.otherImprovement = "";
        this.IDOcupation = 0;
        this.otherOcupation = "";
        this.degreeSchool = 0;
        this.liveWith = 0;
        this.otherDweller = "";
        this.hasChildren = false;
        this.religion = 0;
        this.aboutElection = 0;
        this.willVote = false;
        this.howSelectCandidate = 0;
        this.whatTheyDo = false;
        this.describePoliticJob = 0;
        this.knowSuperSimples = false;
        this.funcAposentado = false;
        this.aposentada = false;
        this.motivoDesemprego = 0;
        this.desemSelec = 0;
        this.respDesempenho = 0;
        this.otherResp = "";

    }

    public Interview(Long id, Long idPerson,String interviewSent,String verifyAge, String dateStart, String dateFinish,
                     String viewerFound, String viewerAccept, String useSus,
                     String idProcedure, String procedureHospital, String IDHospital,
                     String otherHospital, String useMedicalPlan, String IDProblemWithPlan,
                     String IDSickness, String needGetBetter, String qualityOfSus, String otherImprovement,
                     String IDOcupation, String otherOcupation, String degreeSchool,
                     String liveWith, String otherDweller, String hasChildren,
                     String religion, String aboutElection, String willVote,
                     String howSelectCandidate, String whatTheyDo, String describePoliticJob,
                     String knowSuperSimples, String funcAposentado, String aposentada,
                     String motivoDesemprego, String desemSelec, String respDesempenho, String otherResp) {
        this.id = id;
        this.idPerson = idPerson;
        this.interviewSent = Boolean.parseBoolean(interviewSent);
        this.verifyAge = Boolean.parseBoolean(verifyAge);
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.viewerFound = Boolean.parseBoolean(viewerFound);
        this.viewerAccept = Boolean.parseBoolean(viewerAccept);
        this.useSus = Boolean.parseBoolean(useSus);
        this.idProcedure = Short.parseShort(idProcedure);
        this.procedureHospital = Boolean.parseBoolean(procedureHospital);
        this.IDHospital = Short.parseShort(IDHospital);
        this.otherHospital = otherHospital;
        this.useMedicalPlan = Boolean.parseBoolean(useMedicalPlan);
        this.IDProblemWithPlan = Short.parseShort(IDProblemWithPlan);
        this.IDSickness = Short.parseShort(IDSickness);
        this.needGetBetter = Short.parseShort(needGetBetter);
        this.qualityOfSus = Short.parseShort(qualityOfSus);
        this.otherImprovement = otherImprovement;
        this.IDOcupation = Short.parseShort(IDOcupation);
        this.otherOcupation = otherOcupation;
        this.degreeSchool = Short.parseShort(degreeSchool);
        this.liveWith = Short.parseShort(liveWith);
        this.otherDweller = otherDweller;
        this.hasChildren = Boolean.parseBoolean(hasChildren);
        this.religion = Short.parseShort(religion);
        this.aboutElection = Short.parseShort(aboutElection);
        this.willVote = Boolean.parseBoolean(willVote);
        this.howSelectCandidate = Short.parseShort(howSelectCandidate);
        this.whatTheyDo = Boolean.parseBoolean(whatTheyDo);
        this.describePoliticJob = Short.parseShort(describePoliticJob);
        this.knowSuperSimples = Boolean.parseBoolean(knowSuperSimples);
        this.funcAposentado = Boolean.parseBoolean(funcAposentado);
        this.aposentada = Boolean.parseBoolean(aposentada);
        this.motivoDesemprego = Short.parseShort(motivoDesemprego);
        this.desemSelec = Short.parseShort(desemSelec);
        this.respDesempenho = Short.parseShort(respDesempenho);
        this.otherResp = otherResp;
    }

    @Generated(hash = 691904881)
    public Interview(Long id, @NotNull Long idPerson, boolean interviewSent, boolean verifyAge, String dateStart,
            String dateFinish, boolean viewerFound, boolean viewerAccept, boolean useSus, short idProcedure,
            boolean procedureHospital, short IDHospital, String otherHospital, boolean useMedicalPlan,
            short IDProblemWithPlan, short IDSickness, short needGetBetter, short qualityOfSus, String otherImprovement,
            short IDOcupation, String otherOcupation, short degreeSchool, short liveWith, String otherDweller,
            boolean hasChildren, short religion, short aboutElection, boolean willVote, short howSelectCandidate,
            boolean whatTheyDo, short describePoliticJob, boolean knowSuperSimples, boolean funcAposentado,
            boolean aposentada, short motivoDesemprego, short desemSelec, short respDesempenho, String otherResp) {
        this.id = id;
        this.idPerson = idPerson;
        this.interviewSent = interviewSent;
        this.verifyAge = verifyAge;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.viewerFound = viewerFound;
        this.viewerAccept = viewerAccept;
        this.useSus = useSus;
        this.idProcedure = idProcedure;
        this.procedureHospital = procedureHospital;
        this.IDHospital = IDHospital;
        this.otherHospital = otherHospital;
        this.useMedicalPlan = useMedicalPlan;
        this.IDProblemWithPlan = IDProblemWithPlan;
        this.IDSickness = IDSickness;
        this.needGetBetter = needGetBetter;
        this.qualityOfSus = qualityOfSus;
        this.otherImprovement = otherImprovement;
        this.IDOcupation = IDOcupation;
        this.otherOcupation = otherOcupation;
        this.degreeSchool = degreeSchool;
        this.liveWith = liveWith;
        this.otherDweller = otherDweller;
        this.hasChildren = hasChildren;
        this.religion = religion;
        this.aboutElection = aboutElection;
        this.willVote = willVote;
        this.howSelectCandidate = howSelectCandidate;
        this.whatTheyDo = whatTheyDo;
        this.describePoliticJob = describePoliticJob;
        this.knowSuperSimples = knowSuperSimples;
        this.funcAposentado = funcAposentado;
        this.aposentada = aposentada;
        this.motivoDesemprego = motivoDesemprego;
        this.desemSelec = desemSelec;
        this.respDesempenho = respDesempenho;
        this.otherResp = otherResp;
    }


    public String getDateStart() {

        if (dateStart != null)
            return dateStart;
        else return "";
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateFinish() {
        if (dateFinish != null)
            return dateFinish;
        else return "";
    }

    public void setDateFinish(String dateFinish) {
        this.dateFinish = dateFinish;
    }

    public String dateStart;
    public String dateFinish;

    public boolean viewerFound;
    public boolean viewerAccept;
    public boolean useSus;
    /* Pode ser:
        1- Urgencia
        2- Consultas
        3- Exames
        4- Vacinacao
        5- Pre-Natal/Parto
        6- Odotonlogia
    */
    public short idProcedure;
    /*
        Foi realizado em um hospital de bh
     */
    public boolean procedureHospital;

    /*
        Id do hospital:
        1- Hospital da baleia
        2- Joao XXIII
        3- Hospital Evangélico
        4- Felicio Rocho
        5- Julia Kubitschek
        6- Eduardo de Meneses
        7- Alberto Cavalcanti
        8- Madre Teresa
        9- Outros
     */
    public short IDHospital;
    public String otherHospital;
    public boolean useMedicalPlan;
    /*
        Id problemas com plano:
        1- Autorizacao de procedimento
        2- Falta de medico especialista
        3- Descredenciamento de medico
        4- Descredenciamento de laboratorios, clinicas e hosp
        5- Problemas com custos
        6- Dificuldade para pagar mensalidade
        7- Demora para marcar consultas
        8- Nao tive problemas
     */

    public short IDProblemWithPlan;
    /*
        Alguem na familia possui doenca grave:
        1- Cancer
        2- Doencas hepaticas
        4- Cardiaco
        5- Asma
        6- Outras
        7- Não possui
     */
    public short IDSickness;

    /*
        Precisa melhorar
        1- Contratar medicos
        2- Reforma e ampliacao de hosp
        3- Construcao de novos hosp
        4- Diminuir tempo para marcar consulta
        5- Diminuir tempo para marcar cirurgia
        6- Realização de exames
        7- Outros
     */
    public short needGetBetter;
    /*
        qualidade do SUS:
        1- Otimo
        2- Bom
        3- Regular
        4- Ruim
        5- Pessimo

     */
    public short qualityOfSus;

    public String otherImprovement;

    /*
        Ocupacao
        1- Funcionario
        2- Desempregado
        3- Dona de casa
        4- Estudante
        5- Empresario
        6- Liberal
        7- Aposentado

     */
    public short IDOcupation;
    public String otherOcupation;
    /*
        Ocupacao
        1- Nivel Superior
        2- Curso tecnico
        3- Pos
        4- Concurso

     */
    public short degreeSchool;
    /*
        Mora com
        1- Pais
        2- Avos
        3- Conjuge

     */
    public short liveWith;

    public String otherDweller;

    public boolean hasChildren;

    /*
        religiao
        1- Catolico
        2- Protestante
        3- Não possui
        4- outros

     */
    public short religion;
    /*
        sobre as eleicoes
        1- Melhorar o brasil
        2- piorar o brasil
        3- Não altera
        4- Depende de quem for eleito

     */
    public short aboutElection;

    public boolean willVote;

    /*
        como seleciona candidato
        1- Passado limpo
        2- Acoes e trabalhos
        3- simpatia
        4- confianca
        5- Atua na regiao
        6- honestidade

     */
    public short howSelectCandidate;

    public boolean whatTheyDo;

    /*
        Trabalho do deputado
        1- Aprova leis
        2- Destinacao de verbas
        3- cria leis
        4- fiscalizacao uso dinheiro publico
        5- Nenhuma das opções anteriores

     */
    public short describePoliticJob;

    public boolean knowSuperSimples;

    public boolean funcAposentado;

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public void setViewerFound(boolean viewerFound) {
        this.viewerFound = viewerFound;
    }

    public void setViewerAccept(boolean viewerAccept) {
        this.viewerAccept = viewerAccept;
    }

    public void setUseSus(boolean useSus) {
        this.useSus = useSus;
    }

    public void setIdProcedure(short idProcedure) {
        this.idProcedure = idProcedure;
    }

    public void setProcedureHospital(boolean procedureHospital) {
        this.procedureHospital = procedureHospital;
    }

    public void setIDHospital(short IDHospital) {
        this.IDHospital = IDHospital;
    }

    public void setOtherHospital(String otherHospital) {
        this.otherHospital = otherHospital;
    }

    public void setUseMedicalPlan(boolean useMedicalPlan) {
        this.useMedicalPlan = useMedicalPlan;
    }

    public void setIDProblemWithPlan(short IDProblemWithPlan) {
        this.IDProblemWithPlan = IDProblemWithPlan;
    }

    public void setIDSickness(short IDSickness) {
        this.IDSickness = IDSickness;
    }

    public void setNeedGetBetter(short needGetBetter) {
        this.needGetBetter = needGetBetter;
    }

    public void setQualityOfSus(short qualityOfSus) {
        this.qualityOfSus = qualityOfSus;
    }

    public void setOtherImprovement(String otherImprovement) {
        this.otherImprovement = otherImprovement;
    }

    public void setIDOcupation(short IDOcupation) {
        this.IDOcupation = IDOcupation;
    }

    public void setOtherOcupation(String otherOcupation) {
        this.otherOcupation = otherOcupation;
    }

    public void setDegreeSchool(short degreeSchool) {
        this.degreeSchool = degreeSchool;
    }

    public void setLiveWith(short liveWith) {
        this.liveWith = liveWith;
    }

    public void setOtherDweller(String otherDweller) {
        this.otherDweller = otherDweller;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public void setReligion(short religion) {
        this.religion = religion;
    }

    public void setAboutElection(short aboutElection) {
        this.aboutElection = aboutElection;
    }

    public void setWillVote(boolean willVote) {
        this.willVote = willVote;
    }

    public void setHowSelectCandidate(short howSelectCandidate) {
        this.howSelectCandidate = howSelectCandidate;
    }

    public void setWhatTheyDo(boolean whatTheyDo) {
        this.whatTheyDo = whatTheyDo;
    }

    public void setDescribePoliticJob(short describePoliticJob) {
        this.describePoliticJob = describePoliticJob;
    }

    public void setKnowSuperSimples(boolean knowSuperSimples) {
        this.knowSuperSimples = knowSuperSimples;
    }

    public void setFuncAposentado(boolean funcAposentado) {
        this.funcAposentado = funcAposentado;
    }

    public void setAposentada(boolean aposentada) {
        this.aposentada = aposentada;
    }

    public void setMotivoDesemprego(short motivoDesemprego) {
        this.motivoDesemprego = motivoDesemprego;
    }

    public void setDesemSelec(short desemSelec) {
        this.desemSelec = desemSelec;
    }

    public void setRespDesempenho(short respDesempenho) {
        this.respDesempenho = respDesempenho;
    }

    public void setOtherResp(String otherResp) {
        this.otherResp = otherResp;
    }


    public boolean aposentada;

    /*

        1- Falta de oportunidade
        2- Ausencia de curso
        3- dificuldade de crescimento economio
        4- falta de mao de obra
        5- falta de investimento educacao

     */
    public short motivoDesemprego;
    /*
        1- Otimo
        2- Bom
        3- Regular
        4- Ruim
        5- Pessimo
     */
    public short desemSelec;

    /*
        1- CBF
        2- Tecnico
        3- Jogadores
     */
    public short respDesempenho;

    public String isOtherResp() {
        if (otherResp != null)
            return otherResp;
        else return "";
    }

    public short isRespDesempenho() {
        return respDesempenho;
    }

    public short isDesemSelec() {
        return desemSelec;
    }

    public short isMotivoDesemprego() {
        return motivoDesemprego;
    }

    public boolean isAposentada() {
        return aposentada;
    }

    public boolean isFuncAposentado() {
        return funcAposentado;
    }

    public boolean isKnowSuperSimples() {
        return knowSuperSimples;
    }

    public short isDescribePoliticJob() {
        return describePoliticJob;
    }

    public boolean isWhatTheyDo() {
        return whatTheyDo;
    }

    public short isHowSelectCandidate() {
        return howSelectCandidate;
    }

    public boolean isWillVote() {
        return willVote;
    }

    public short isAboutElection() {
        return aboutElection;
    }

    public short isReligion() {
        return religion;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public String isOtherDweller() {
        if(otherDweller != null)
            return otherDweller;
        else return "";
    }

    public short isLiveWith() {
        return liveWith;
    }

    public short isDegreeSchool() {
        return degreeSchool;
    }

    public String isOtherOcupation() {
        if(otherOcupation != null)
            return otherOcupation;
        else return "";
    }

    public short isIDOcupation() {
        return IDOcupation;
    }

    public String isOtherImprovement() {
        if(otherImprovement != null)
            return otherImprovement;
        else return "";
    }

    public short isQualityOfSus() {
        return qualityOfSus;
    }

    public short getNeedGetBetter() {
        return needGetBetter;
    }

    public short isIDSickness() {
        return IDSickness;
    }

    public short isIDProblemWithPlan() {
        return IDProblemWithPlan;
    }

    public boolean isUseMedicalPlan() {
        return useMedicalPlan;
    }

    public String isOtherHospital() {
        if (otherHospital != null)
            return otherHospital;
        else return "";
    }

    public short isIDHospital() {
        return IDHospital;
    }

    public boolean isProcedureHospital() {
        return procedureHospital;
    }

    public short isIdProcedure() {
        return idProcedure;
    }

    public boolean isUseSus() {
        return useSus;
    }

    public boolean isViewerAccept() {
        return viewerAccept;
    }

    public boolean isViewerFound() {
        return viewerFound;
    }

    public String otherResp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long isIdPerson() {
        return idPerson;
    }

    public Long getIdPerson() {
        return this.idPerson;
    }

    public boolean getInterviewSent() {
        return this.interviewSent;
    }

    public boolean getVerifyAge() {
        return this.verifyAge;
    }

    public boolean getViewerFound() {
        return this.viewerFound;
    }

    public boolean getViewerAccept() {
        return this.viewerAccept;
    }

    public boolean getUseSus() {
        return this.useSus;
    }

    public short getIdProcedure() {
        return this.idProcedure;
    }

    public boolean getProcedureHospital() {
        return this.procedureHospital;
    }

    public short getIDHospital() {
        return this.IDHospital;
    }

    public String getOtherHospital() {
        return this.otherHospital;
    }

    public boolean getUseMedicalPlan() {
        return this.useMedicalPlan;
    }

    public short getIDProblemWithPlan() {
        return this.IDProblemWithPlan;
    }

    public short getIDSickness() {
        return this.IDSickness;
    }

    public short getQualityOfSus() {
        return this.qualityOfSus;
    }

    public String getOtherImprovement() {
        return this.otherImprovement;
    }

    public short getIDOcupation() {
        return this.IDOcupation;
    }

    public String getOtherOcupation() {
        return this.otherOcupation;
    }

    public short getDegreeSchool() {
        return this.degreeSchool;
    }

    public short getLiveWith() {
        return this.liveWith;
    }

    public String getOtherDweller() {
        return this.otherDweller;
    }

    public boolean getHasChildren() {
        return this.hasChildren;
    }

    public short getReligion() {
        return this.religion;
    }

    public short getAboutElection() {
        return this.aboutElection;
    }

    public boolean getWillVote() {
        return this.willVote;
    }

    public short getHowSelectCandidate() {
        return this.howSelectCandidate;
    }

    public boolean getWhatTheyDo() {
        return this.whatTheyDo;
    }

    public short getDescribePoliticJob() {
        return this.describePoliticJob;
    }

    public boolean getKnowSuperSimples() {
        return this.knowSuperSimples;
    }

    public boolean getFuncAposentado() {
        return this.funcAposentado;
    }

    public boolean getAposentada() {
        return this.aposentada;
    }

    public short getMotivoDesemprego() {
        return this.motivoDesemprego;
    }

    public short getDesemSelec() {
        return this.desemSelec;
    }

    public short getRespDesempenho() {
        return this.respDesempenho;
    }

    public String getOtherResp() {
        return this.otherResp;
    }
}
