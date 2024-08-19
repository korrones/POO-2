public class Main {

    public static void main(String[] args) {
        CriarTabelas criarTabelas = new CriarTabelas();
        criarTabelas.criarTabelas();

        ProjetoDAO projetoDAO = new ProjetoDAO();
        EngenheiroDAO engenheiroDAO = new EngenheiroDAO();
        OperarioDAO operarioDAO = new OperarioDAO();
        EquipamentoDAO equipamentoDAO = new EquipamentoDAO();
        MaterialDAO materialDAO = new MaterialDAO();
        AlocacaoEngenheiroDAO alocacaoEngenheiroDAO = new AlocacaoEngenheiroDAO();
        AlocacaoOperarioDAO alocacaoOperarioDAO = new AlocacaoOperarioDAO();
        UsoEquipamentoDAO usoEquipamentoDAO = new UsoEquipamentoDAO();
        ConsumoMaterialDAO consumoMaterialDAO = new ConsumoMaterialDAO();

        Projeto projeto = new Projeto();
        projeto.setNomeProjeto("Construção da Univille");
        projeto.setLocal("Bom Retiro");
        projeto.setDataInicio("2024-01-01");
        projeto.setDataTermino("2024-12-31");
        projetoDAO.inserir(projeto);

        Engenheiro engenheiro = new Engenheiro();
        engenheiro.setNomeEngenheiro("Karolina Ferreira");
        engenheiro.setEspecialidade("Estruturas");
        engenheiroDAO.inserir(engenheiro);

        Operario operario = new Operario();
        operario.setNomeOperario("Luca Mesadri");
        operario.setFuncao("Pedreiro");
        operarioDAO.inserir(operario);

        Equipamento equipamento = new Equipamento();
        equipamento.setNomeEquipamento("Betoneira");
        equipamento.setTipo("Construção");
        equipamentoDAO.inserir(equipamento);

        Material material = new Material();
        material.setNomeMaterial("Cimento");
        material.setQuantidade(100);
        materialDAO.inserir(material);

        int idProjeto = 1;
        int idEngenheiro = 1;
        int idOperario = 1;
        int idEquipamento = 1;
        int idMaterial = 1;


        alocacaoEngenheiroDAO.alocarEngenheiro(idProjeto, idEngenheiro);
        alocacaoOperarioDAO.alocarOperario(idProjeto, idOperario);
        usoEquipamentoDAO.usarEquipamento(idProjeto, idEquipamento);
        consumoMaterialDAO.consumirMaterial(idProjeto, idMaterial);

        System.out.println("Projetos:");
        for (Projeto p : projetoDAO.listar()) {
            System.out.println(p);
        }

        System.out.println("Engenheiros:");
        for (Engenheiro e : engenheiroDAO.listar()) {
            System.out.println(e);
        }

        System.out.println("Operários:");
        for (Operario o : operarioDAO.listar()) {
            System.out.println(o);
        }

        System.out.println("Equipamentos:");
        for (Equipamento e : equipamentoDAO.listar()) {
            System.out.println(e);
        }

        System.out.println("Materiais:");
        for (Material m : materialDAO.listar()) {
            System.out.println(m);
        }

    }
}
