package com.nutrilens.api.service.impl;

import com.nutrilens.api.dto.request.CreateNutritionTipRequestDTO;
import com.nutrilens.api.dto.response.NutritionTipResponseDTO;
import com.nutrilens.api.entity.NutritionTip;
import com.nutrilens.api.exception.EntityNotFoundException;
import com.nutrilens.api.repository.NutritionTipRepository;
import com.nutrilens.api.service.NutritionTipService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class NutritionTipServiceImpl implements NutritionTipService {

    private final NutritionTipRepository nutritionTipRepository;

    public NutritionTipServiceImpl(NutritionTipRepository nutritionTipRepository) {
        this.nutritionTipRepository = nutritionTipRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NutritionTipResponseDTO> getAllActiveTips(String targetGoal) {
        List<NutritionTip> tips;
        if (targetGoal != null && !targetGoal.trim().isEmpty() && !targetGoal.equalsIgnoreCase("ALL")) {
            tips = nutritionTipRepository.findByIsActiveTrueAndTargetGoalInOrderByIdAsc(
                    Arrays.asList("ALL", targetGoal.toUpperCase())
            );
        } else {
            tips = nutritionTipRepository.findByIsActiveTrueOrderByIdAsc();
        }

        return tips.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public NutritionTipResponseDTO getRandomTip() {
        NutritionTip tip = nutritionTipRepository.findRandomActiveTip()
                .orElseThrow(() -> new EntityNotFoundException("Không tìm thấy mẹo dinh dưỡng nào trong hệ thống"));
        return mapToDTO(tip);
    }

    @Override
    @Transactional
    public NutritionTipResponseDTO createTip(CreateNutritionTipRequestDTO request) {
        NutritionTip tip = NutritionTip.builder()
                .title(request.getTitle().trim())
                .content(request.getContent().trim())
                .category(request.getCategory().trim().toUpperCase())
                .iconType(request.getIconType() != null ? request.getIconType().trim().toLowerCase() : "salad")
                .targetGoal(request.getTargetGoal() != null ? request.getTargetGoal().trim().toUpperCase() : "ALL")
                .isActive(request.getIsActive() != null ? request.getIsActive() : true)
                .build();

        NutritionTip savedTip = nutritionTipRepository.save(tip);
        return mapToDTO(savedTip);
    }

    @Override
    @Transactional(readOnly = true)
    public NutritionTipResponseDTO getTipById(Long id) {
        NutritionTip tip = nutritionTipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mẹo dinh dưỡng với ID " + id + " không tồn tại"));
        return mapToDTO(tip);
    }

    @Override
    @Transactional
    public void deleteTip(Long id) {
        NutritionTip tip = nutritionTipRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Mẹo dinh dưỡng với ID " + id + " không tồn tại"));
        nutritionTipRepository.delete(tip);
    }

    private NutritionTipResponseDTO mapToDTO(NutritionTip tip) {
        return NutritionTipResponseDTO.builder()
                .id(tip.getId())
                .title(tip.getTitle())
                .content(tip.getContent())
                .category(tip.getCategory())
                .iconType(tip.getIconType())
                .targetGoal(tip.getTargetGoal())
                .isActive(tip.getIsActive())
                .createdAt(tip.getCreatedAt())
                .build();
    }
}
