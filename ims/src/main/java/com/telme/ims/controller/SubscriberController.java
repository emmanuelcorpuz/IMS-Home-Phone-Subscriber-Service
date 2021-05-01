package com.telme.ims.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telme.ims.beans.SubscriberBean;
import com.telme.ims.model.Feature;
import com.telme.ims.model.Subscriber;
import com.telme.ims.model.SubscriberFeature;
import com.telme.ims.services.SubscriberService;



@RestController
@RequestMapping("/ims")
public class SubscriberController {
	Logger log = LoggerFactory.getLogger(SubscriberController.class);
	
	@Autowired
	private SubscriberService subscriberService;
	
	@GetMapping(path = "/subscriber/{phoneNumber}", produces = "application/json")
	public ResponseEntity<?> getSubscriberbyPhoneNumber(@PathVariable Long phoneNumber){
		log.debug("getSubscriberbyPhoneNumber() - Start");

		Optional<Subscriber> optional = subscriberService.findByPhoneNumber(phoneNumber);
		
		SubscriberBean subscriberBean =  new SubscriberBean();
		if(optional.isPresent()) {
			Subscriber subscriber = optional.get();
			
			List<Feature> features = new ArrayList<Feature>();
			for (SubscriberFeature subscriberFeature : subscriber.getSubscriberFeatures()) {
				Optional<Feature> optionalFeature = subscriberService.findFeatureById(subscriberFeature.getFeatureid());
				if(optionalFeature.isPresent()) {
					features.add(optionalFeature.get());
				}
			}
			
			subscriberBean = new SubscriberBean(subscriber.getPhonenumber(), subscriber.getUsername(), subscriber.getPassword(), subscriber.getDomain(),subscriber.getStatus(), features);
		}

		log.debug("getSubscriberbyPhoneNumber() - Return");
		return new ResponseEntity<>(subscriberBean,HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/subscriber/{phoneNumber}", produces = "application/json")
	public ResponseEntity<?> deleteSubscriberbyPhoneNumber(@PathVariable Long phoneNumber){
		log.debug("deleteSubscriberbyPhoneNumber() - Start");

		subscriberService.deleteByPhoneNumber(phoneNumber);

		log.debug("deleteSubscriberbyPhoneNumber() - Return");
		return new ResponseEntity<>(phoneNumber,HttpStatus.OK);
	}
	
	@PutMapping(path = "/subscriber/{phoneNumber}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> putSubscriber (@RequestBody SubscriberBean subscriberBean, @RequestHeader HttpHeaders headers, HttpServletRequest request){
		log.debug("putSubscriber() - Start");
		
		List<SubscriberFeature> subscriberFeatures = new ArrayList<SubscriberFeature>();
		boolean isMissingFeature = false;
		List<Feature> features = new ArrayList<Feature>();
		for (Feature feature : subscriberBean.getFeatures()) {
			Optional<Feature> optionalFeature = subscriberService.findFeatureById(feature.getFeatureid());
			if(optionalFeature.isPresent()) {
				Feature feature1 = optionalFeature.get();
				features.add(optionalFeature.get());
				SubscriberFeature subscriberFeature = new SubscriberFeature();
				subscriberFeature.setFeatureid(feature1.getFeatureid());
				subscriberFeature.setPhonenumber(subscriberBean.getPhoneNumber());
				subscriberFeatures.add(subscriberFeature);
			} else {
				isMissingFeature = true;
			}
		}
		
		SubscriberBean subscriberBeanReturn =  new SubscriberBean();
		if (!isMissingFeature) {
			Subscriber subscriber = new Subscriber(subscriberBean.getPhoneNumber(), subscriberBean.getUsername(), subscriberBean.getPassword(), subscriberBean.getDomain(),subscriberBean.getStatus(), subscriberFeatures);
			if(subscriberService.putSubscriber(subscriber) != null) {
				subscriberBeanReturn = new SubscriberBean(subscriber.getPhonenumber(), subscriber.getUsername(), subscriber.getPassword(), subscriber.getDomain(),subscriber.getStatus(), features);
			}
		}

		log.debug("putSubscriber() - Return");
		return new ResponseEntity<>(subscriberBeanReturn,HttpStatus.OK);
	}

}
