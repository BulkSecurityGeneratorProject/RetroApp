package com.feedback.service.impl;

import com.feedback.domain.Points;
import com.feedback.repository.PointsRepository;
import com.feedback.service.PointsService;
import com.feedback.service.dto.PointsDTO;
import com.feedback.service.mapper.PointsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Points.
 */
@Service
@Transactional
public class PointsServiceImpl implements PointsService{

    private final Logger log = LoggerFactory.getLogger(PointsServiceImpl.class);

    private final PointsRepository pointsRepository;

    private final PointsMapper pointsMapper;
    public PointsServiceImpl(PointsRepository pointsRepository, PointsMapper pointsMapper) {
        this.pointsRepository = pointsRepository;
        this.pointsMapper = pointsMapper;
    }

    /**
     * Save a points.
     *
     * @param pointsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PointsDTO save(PointsDTO pointsDTO) {
        log.debug("Request to save Points : {}", pointsDTO);
        Points points = pointsMapper.toEntity(pointsDTO);
        points = pointsRepository.save(points);
        return pointsMapper.toDto(points);
    }

    /**
     *  Get all the points.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PointsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Points");
        return pointsRepository.findAll(pageable)
            .map(pointsMapper::toDto);
    }

    /**
     *  Get one points by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public PointsDTO findOne(Long id) {
        log.debug("Request to get Points : {}", id);
        Points points = pointsRepository.findOne(id);
        return pointsMapper.toDto(points);
    }

    /**
     *  Delete the  points by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Points : {}", id);
        pointsRepository.delete(id);
    }
}
