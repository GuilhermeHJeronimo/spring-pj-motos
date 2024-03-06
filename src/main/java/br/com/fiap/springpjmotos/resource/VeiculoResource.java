package br.com.fiap.springpjmotos.resource;

import br.com.fiap.springpjmotos.entity.Acessorio;
import br.com.fiap.springpjmotos.entity.Loja;
import br.com.fiap.springpjmotos.entity.Veiculo;
import br.com.fiap.springpjmotos.repository.AcessorioRepository;
import br.com.fiap.springpjmotos.repository.LojaRepository;
import br.com.fiap.springpjmotos.repository.TipoVeiculoRepository;
import br.com.fiap.springpjmotos.repository.VeiculoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "localhost/veiculos")
public class VeiculoResource {
    @Autowired
    private VeiculoRepository repo;

    @Autowired
    private LojaRepository lojaRepository;

    @Autowired
    private TipoVeiculoRepository tipoVeiculoRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @GetMapping
    public List<Veiculo> findAll(){
        return repo.findAll();
    }

    @Transactional
    @PostMapping
    public Veiculo persist(@RequestBody Veiculo veiculo){
        return repo.save(veiculo);
    }
    @GetMapping(value = "/{id}")
    public Veiculo findAll(@PathVariable("id") Long id) {
        var ret = repo.findById(id);
        return ret.get();
    }
    @GetMapping(value = "/{id}/acessorios")
    public Acessorio findAcessorios(@PathVariable("id") Long id) {
        var ret = acessorioRepository.findById(id);
        return ret.get();
    }





}
