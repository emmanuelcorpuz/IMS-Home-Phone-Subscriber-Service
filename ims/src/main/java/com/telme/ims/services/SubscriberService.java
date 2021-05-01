package com.telme.ims.services;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.telme.ims.model.Feature;
import com.telme.ims.model.Subscriber;
import com.telme.ims.repository.FeatureRepository;
import com.telme.ims.repository.SubscriberRepository;

@Service
@Transactional
public class SubscriberService {
	private final SubscriberRepository subscriberRepository;
	private final FeatureRepository featureRepository;
	
	@PersistenceContext
	private EntityManager em;

	public SubscriberService(SubscriberRepository subscriberRepository, FeatureRepository featureRepository) {
		this.subscriberRepository = subscriberRepository;
		this.featureRepository = featureRepository;
	}
	
	public Optional<Subscriber> findByPhoneNumber(long phoneNumber) {
		return subscriberRepository.findById(phoneNumber);
	}
	
	public Optional<Feature> findFeatureById(int featureid) {
		return featureRepository.findById(featureid);
	}
	
	public void deleteByPhoneNumber(long phoneNumber) {
		subscriberRepository.deleteById(phoneNumber);
	}
	
	public Subscriber putSubscriber(Subscriber subscriber) {
		return subscriberRepository.save(subscriber);
	}

}
