package wwirzbicki.dao;

import org.springframework.data.repository.CrudRepository;

import wwirzbicki.model.Sequence;

public interface SequenceRepository extends CrudRepository<Sequence, String>{

}
