using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Web.InterviewAssistant.DB.Model
{
    public class Interview
    {
        public int interviewId { get; set; }
        int idPerson { get; set; }

        public bool verifyAge { get; set; }

        public string dateStart { get; set; }
        public string dateFinish { get; set; }

        public bool viewerFound { get; set; }
        public bool viewerAccept { get; set; }
        public bool useSus { get; set; }
        /* Pode ser:
            1- Urgencia
            2- Consultas
            3- Exames
            4- Vacinacao
            5- Pre-Natal/Parto
            6- Odotonlogia
        */
        public short idProcedure { get; set; }
        /*
            Foi realizado em um hospital de bh
         */
        public bool procedureHospital { get; set; }

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
        public short IDHospital { get; set; }
        public string otherHospital { get; set; }
        public bool useMedicalPlan { get; set; }
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

        public short IDProblemWithPlan { get; set; }
        /*
            Alguem na familia possui doenca grave:
            1- Cancer
            2- Doencas hepaticas
            4- Cardiaco
            5- Asma
            6- Outras
            7- Não possui
         */
        public short IDSickness { get; set; }

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
        public short needGetBetter { get; set; }
        /*
            qualidade do SUS:
            1- Otimo
            2- Bom
            3- Regular
            4- Ruim
            5- Pessimo

         */
        public short qualityOfSus { get; set; }

        public string otherImprovement { get; set; }

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
        public short IDOcupation { get; set; }
        public string otherOcupation { get; set; }
        /*
            Ocupacao
            1- Nivel Superior
            2- Curso tecnico
            3- Pos
            4- Concurso

         */
        public short degreeSchool { get; set; }
        /*
            Mora com
            1- Pais
            2- Avos
            3- Conjuge

         */
        public short liveWith { get; set; }

        public string otherDweller { get; set; }

        public bool hasChildren { get; set; }

        /*
            religiao
            1- Catolico
            2- Protestante
            3- Não possui
            4- outros

         */
        public short religion { get; set; }
        /*
            sobre as eleicoes
            1- Melhorar o brasil
            2- piorar o brasil
            3- Não altera
            4- Depende de quem for eleito

         */
        public short aboutElection { get; set; }

        public bool willVote { get; set; }

        /*
            como seleciona candidato
            1- Passado limpo
            2- Acoes e trabalhos
            3- simpatia
            4- confianca
            5- Atua na regiao
            6- honestidade

         */
        public short howSelectCandidate { get; set; }

        public bool whatTheyDo { get; set; }

        /*
            Trabalho do deputado
            1- Aprova leis
            2- Destinacao de verbas
            3- cria leis
            4- fiscalizacao uso dinheiro publico
            5- Nenhuma das opções anteriores

         */
        public short describePoliticJob { get; set; }

        public bool knowSuperSimples { get; set; }

        public bool funcAposentado { get; set; }

        public bool aposentada { get; set; }

        /*

            1- Falta de oportunidade
            2- Ausencia de curso
            3- dificuldade de crescimento economio
            4- falta de mao de obra
            5- falta de investimento educacao

         */
        public short motivoDesemprego { get; set; }
        /*
            1- Otimo
            2- Bom
            3- Regular
            4- Ruim
            5- Pessimo
         */
        public short desemSelec { get; set; }

        /*
            1- CBF
            2- Tecnico
            3- Jogadores
         */
        public short respDesempenho { get; set; }

    }
}
