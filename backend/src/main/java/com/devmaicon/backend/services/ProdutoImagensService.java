package com.devmaicon.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.devmaicon.backend.entities.Produto;
import com.devmaicon.backend.entities.ProdutoImagens;
import com.devmaicon.backend.repositories.ProdutoImagensRepository;
import com.devmaicon.backend.repositories.ProdutoRepository;

@Service
public class ProdutoImagensService {

    @Autowired
    private ProdutoImagensRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagens> buscarTodos() {
        return repository.findAll();
    }

    public ProdutoImagens inserir(Long idProduto, MultipartFile file) {
        Produto produto = produtoRepository.findById(idProduto).get();

        ProdutoImagens objeto = new ProdutoImagens();

        try {
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId())
                        + file.getOriginalFilename();
                Path caminho = Paths
                        .get("C:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);

                objeto.setNome(nomeImagem);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        objeto.setProduto(produto);
        objeto.setDataCriacao(new Date());
        objeto = repository.saveAndFlush(objeto);
        return objeto;
    }

    public ProdutoImagens alterar(ProdutoImagens obj) {
        obj.setDataAtualizacao(new Date());
        return repository.saveAndFlush(obj);
    }

    public void remover(Long id) {
        ProdutoImagens obj = repository.findById(id).get();

        String nomeImagem = obj.getNome();

        repository.delete(obj);

        Path caminhoDaImagem = Paths.get("C:/imagens/" + nomeImagem);

        try {
            Files.delete(caminhoDaImagem);
            System.out.println("Imagem deletada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            // Lidar com a exceção de IO conforme necessário
        }
    }

}
