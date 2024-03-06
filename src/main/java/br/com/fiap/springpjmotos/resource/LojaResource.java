package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Loja;
import br.com.fiap.springpjmotos.repository.AcessorioRepository;
import br.com.fiap.springpjmotos.repository.LojaRepository;
import br.com.fiap.springpjmotos.repository.TipoVeiculoRepository;
import br.com.fiap.springpjmotos.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/loja")
public class LojaResource {
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
    public Loja persist(@RequestBody Loja loja) {
        return lojaRepository.save(loja);
    }

    @GetMapping(value = "/{id}")
    public Loja findLoja(@PathVariable("id") Long id) {
        var ret = lojaRepository.findById(id);
        return ret.get();
    }
}
