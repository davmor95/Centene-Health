package com.cognixia.jump.events;

import com.cognixia.jump.model.Dependent;
import com.cognixia.jump.model.Enrollee;
import com.cognixia.jump.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

/**
 * Model Listener for Dependent
 * @author David Morales
 * @version v1 (10/14/20)
 */

public class DependentModelListener extends AbstractMongoEventListener<Dependent> {
    private SequenceGeneratorService sequenceGenerator;

    /**
     * Overloaded Constructor
     * @author David Morales
     * @param sequenceGenerator a sequence generator service instance
     */

    @Autowired
    public DependentModelListener(SequenceGeneratorService sequenceGenerator) {
        this.sequenceGenerator = sequenceGenerator;
    }

    /**
     * Auto increments the address id before converting
     * @author David Morales
     * @param event that occurs before converting for the Dependent model
     */

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Dependent> event) {
        event.getSource().setId(sequenceGenerator.generateSequence(Dependent.SEQUENCE_NAME));
    }
}
