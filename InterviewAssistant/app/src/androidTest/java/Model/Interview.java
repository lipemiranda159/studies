package Model;

import java.io.Serializable;
import java.io.StringReader;

/**
 * Created by Rafael on 19/01/2017.
 */

public class Interview implements Serializable, IPersistentEntity {
    private static final long serialVersionUID = 1633833011084400384L;
    int id;
    int idPerson;
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

    public String otherResp;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
