package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Loja;
import br.com.fiap.springpjmotos.entity.TipoVeiculo;
import br.com.fiap.springpjmotos.repository.AcessorioRepository;
import br.com.fiap.springpjmotos.repository.LojaRepository;
import br.com.fiap.springpjmotos.repository.TipoVeiculoRepository;
import br.com.fiap.springpjmotos.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "localhost/loja")
public class TipoVeiculoResource {
    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @GetMapping
    public List<Loja> findLoja() {
        return lojaRepository.findAll();
    }

    @Transactional
    @PostMapping
    public TipoVeiculo persist(@RequestBody TipoVeiculo tipoVeiculo) {
        return tipoVeiculoRepository.save(tipoVeiculo);
    }

    @GetMapping(value = "/{id}")
    public TipoVeiculo findLoja(@PathVariable("id") Long id) {
        var ret = tipoVeiculoRepository.findById(id);
        return ret.get();
    }
}

