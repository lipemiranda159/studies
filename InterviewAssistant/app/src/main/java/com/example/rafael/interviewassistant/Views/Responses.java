package com.example.rafael.interviewassistant.Views;

/**
 * Created by Rafael on 11/01/2017.
 */

public class Responses {
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
        qualidade do SUS:
        1- Otimo
        2- Bom
        3- Regular
        4- Ruim
        5- Pessimo

     */
    public short qualityOfSus;
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

    public String otherImprovement;

    //public Ocupation ocupation;


}
