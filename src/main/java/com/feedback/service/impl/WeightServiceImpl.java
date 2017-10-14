package com.feedback.service.impl;

import com.feedback.domain.Weight;
import com.feedback.repository.WeightRepository;
import com.feedback.service.WeightService;
import com.feedback.service.dto.WeightDTO;
import com.feedback.service.mapper.WeightMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Weight.
 */
@Service
@Transactional
public class WeightServiceImpl implements WeightService{

    private final Logger log = LoggerFactory.getLogger(WeightServiceImpl.class);

    private final WeightRepository weightRepository;

    private final WeightMapper weightMapper;
    public WeightServiceImpl(WeightRepository weightRepository, WeightMapper weightMapper) {
        this.weightRepository = weightRepository;
        this.weightMapper = weightMapper;
    }

    /**
     * Save a weight.
     *
     * @param weightDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public WeightDTO save(WeightDTO weightDTO) {
        log.debug("Request to save Weight : {}", weightDTO);
        Weight weight = weightMapper.toEntity(weightDTO);
        weight = weightRepository.save(weight);
        return weightMapper.toDto(weight);
    }

    /**
     *  Get all the weights.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<WeightDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Weights");
        return weightRepository.findAll(pageable)
            .map(weightMapper::toDto);
    }

    /**
     *  Get one weight by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public WeightDTO findOne(Long id) {
        log.debug("Request to get Weight : {}", id);
        Weight weight = weightRepository.findOne(id);
        return weightMapper.toDto(weight);
    }

    /**
     *  Delete the  weight by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Weight : {}", id);
        weightRepository.delete(id);
    }
}
