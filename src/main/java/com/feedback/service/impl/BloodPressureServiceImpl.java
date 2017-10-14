package com.feedback.service.impl;

import com.feedback.domain.BloodPressure;
import com.feedback.repository.BloodPressureRepository;
import com.feedback.service.BloodPressureService;
import com.feedback.service.dto.BloodPressureDTO;
import com.feedback.service.mapper.BloodPressureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing BloodPressure.
 */
@Service
@Transactional
public class BloodPressureServiceImpl implements BloodPressureService{

    private final Logger log = LoggerFactory.getLogger(BloodPressureServiceImpl.class);

    private final BloodPressureRepository bloodPressureRepository;

    private final BloodPressureMapper bloodPressureMapper;
    public BloodPressureServiceImpl(BloodPressureRepository bloodPressureRepository, BloodPressureMapper bloodPressureMapper) {
        this.bloodPressureRepository = bloodPressureRepository;
        this.bloodPressureMapper = bloodPressureMapper;
    }

    /**
     * Save a bloodPressure.
     *
     * @param bloodPressureDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BloodPressureDTO save(BloodPressureDTO bloodPressureDTO) {
        log.debug("Request to save BloodPressure : {}", bloodPressureDTO);
        BloodPressure bloodPressure = bloodPressureMapper.toEntity(bloodPressureDTO);
        bloodPressure = bloodPressureRepository.save(bloodPressure);
        return bloodPressureMapper.toDto(bloodPressure);
    }

    /**
     *  Get all the bloodPressures.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BloodPressureDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BloodPressures");
        return bloodPressureRepository.findAll(pageable)
            .map(bloodPressureMapper::toDto);
    }

    /**
     *  Get one bloodPressure by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public BloodPressureDTO findOne(Long id) {
        log.debug("Request to get BloodPressure : {}", id);
        BloodPressure bloodPressure = bloodPressureRepository.findOne(id);
        return bloodPressureMapper.toDto(bloodPressure);
    }

    /**
     *  Delete the  bloodPressure by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BloodPressure : {}", id);
        bloodPressureRepository.delete(id);
    }
}
