package br.com.gerenciamento.sistema;


import br.com.gerenciamento.sistema.model.*;
import br.com.gerenciamento.sistema.model.enuns.StatusPessoa;
import br.com.gerenciamento.sistema.model.enuns.StatusProduto;
import br.com.gerenciamento.sistema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
public class OdinApplication implements CommandLineRunner {
	@Autowired
	private ClienteRepository pRepo;

	@Autowired
	private ProdutoRepository proRepository;

	@Autowired
	private ItemVendaRepository vendaItem;

	@Autowired
	private VendaRepository venda;

	@Autowired
	private EnderecoRepository endRepository;

	public static void main(String[] args) {
		SpringApplication.run(OdinApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CidadeModel cidadade1 = new CidadeModel(null, "Itambé", "PE");
		CidadeModel cidadade2 = new CidadeModel(null, "Pedras de fogo", "PB");


		EnderecoModel end1 = new EnderecoModel(null, "Rua Eliud Falcão", 140,"55920000", "Centro", "",cidadade1);
		EnderecoModel end2 = new EnderecoModel(null, "Rua Primeiro de janeiro", 140,"583280000", "Centro", "", cidadade2);
		EnderecoModel end3 = new EnderecoModel(null, "Rua Primeiro de janeiro", 140,"583280000", "Centro", "", cidadade2);



		PessoaModel p1 = new PessoaModel(null, "Rafael", "1216842483", StatusPessoa.ATIVO, LocalDateTime.now(), Arrays.asList(end1), null);
		PessoaModel p2 = new PessoaModel(null, "Alvaro", "1111111111", StatusPessoa.ATIVO, LocalDateTime.now(), Arrays.asList(end3, end2), null);

		ProdutoModel pro1 = new ProdutoModel(null, "Boneco", 10.00, 10, StatusProduto.ESTOQUE);
		ProdutoModel pro2 = new ProdutoModel(null, "Carro", 10.00, 10, StatusProduto.ESTOQUE);

		ItemVendaModel itemVenda1 = new ItemVendaModel(null, 10.00, 1 , 50.00, LocalDateTime.now(),  pro1, end1, p1);
		ItemVendaModel itemVenda2 = new ItemVendaModel(null, 10.00, 1 , 50.00, LocalDateTime.now(),  pro2, end1, p2);

		VendaModel venda1 = new VendaModel(null, 10.00, Arrays.asList(itemVenda1, itemVenda2));

		endRepository.saveAll(Arrays.asList(end1, end2, end3));
		pRepo.saveAll(Arrays.asList(p1, p2));
		proRepository.saveAll(Arrays.asList(pro1,pro2));
		vendaItem.saveAll(Arrays.asList(itemVenda1, itemVenda2));
		venda.save(venda1);
	}
}
