package br.ifsul.tads.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ifsul.tads.domain.Diaria;
import br.ifsul.tads.dto.DiariaDTO;
import br.ifsul.tads.repository.DiariaRepository;

@Service
public class DiariaService {

    @Autowired
    private DiariaRepository diariaRepository;


    public DiariaDTO criar(DiariaDTO novaDiaria) {
        Diaria diaria = new Diaria();
        diaria.setExercicio(novaDiaria.getExercicio());
        diaria.setMes(novaDiaria.getMes());
        diaria.setPoder(novaDiaria.getPoder());
        diaria.setOrgao(novaDiaria.getOrgao());
        diariaRepository.save(diaria);
        return novaDiaria;
    }

    public List<DiariaDTO> getAll() {
        List<Diaria> diarias = diariaRepository.findAll();
        return diarias.stream().map(d -> {
            DiariaDTO diariaDTO = new DiariaDTO();
            diariaDTO.setExercicio(d.getExercicio());
            diariaDTO.setMes(d.getMes());
            diariaDTO.setPoder(d.getPoder());
            diariaDTO.setOrgao(d.getOrgao());
            return diariaDTO;
        }).toList();
    }

    public Double somarValorPorPoder(String poder) {
        return diariaRepository.sumValorByPoder(poder);
    }
}
