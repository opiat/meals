package wwirzbicki.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import wwirzbicki.dao.SequenceRepository;
import wwirzbicki.model.Sequence;

@Service
public class SequenceService {
	
	private final SequenceRepository sequenceRepository;
	
	@Autowired
	public SequenceService(SequenceRepository sequenceRepository) {
		this.sequenceRepository = sequenceRepository;
	}

	public long nextValue(String sequenceName){
		Sequence sequence = sequenceRepository.findOne(sequenceName);
		if(sequence == null){
			sequence = new Sequence();
			sequence.setName(sequenceName);
		}
		long nextValue = sequence.getAndIncrement();
		sequenceRepository.save(sequence);
		return nextValue;
	}
}
