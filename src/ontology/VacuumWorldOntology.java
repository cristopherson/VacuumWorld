package ontology;

import ontology.action.Forward;
import ontology.action.Suck;
import ontology.action.Turn;
import ontology.concept.LocationConcept;
import ontology.concept.VacuumConcept;
import ontology.predicate.Dirt;
import ontology.predicate.Facing;
import ontology.predicate.In;
import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.PrimitiveSchema;

public class VacuumWorldOntology extends Ontology {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String ONTOLOGY_NAME = "vacuum-ontology";
	// The singleton instance of this ontology
	private static Ontology instance = new VacuumWorldOntology();

	// Retrieve the singleton vacuum ontology instance
	public static Ontology getInstance() {
		return instance;
	}

	// Vocabulary
	public static final String VACUUM = "vacuum";
	public static final String LOCATION = "location";
	public static final String DIRT = "dirt";
	public static final String IS_DIRT = "isdirt";
	public static final String FACING = "facing";
	public static final String IS_FACING = "isfacing";
	public static final String IN = "in";
	public static final String IS_AT = "isat";
	public static final String FORWARD = "forward";
	public static final String SUCK = "suck";
	public static final String TURN = "turn";
	public static final String ROW = "row";
	public static final String COL = "col";
	public static final String DIRECTION = "direction";

	private VacuumWorldOntology() {
		super(ONTOLOGY_NAME, VacuumWorldOntology.getInstance());

		try {
			add(new ConceptSchema(LOCATION), LocationConcept.class);
			add(new ConceptSchema(VACUUM), VacuumConcept.class);

			add(new PredicateSchema(DIRT), Dirt.class);
			add(new PredicateSchema(IN), In.class);
			add(new PredicateSchema(FACING), Facing.class);

			add(new AgentActionSchema(FORWARD), Forward.class);
			add(new AgentActionSchema(SUCK), Suck.class);
			add(new AgentActionSchema(TURN), Turn.class);

			ConceptSchema vacuumSchema = (ConceptSchema) getSchema(VACUUM);
			vacuumSchema.add(DIRECTION,
					(PrimitiveSchema) getSchema(BasicOntology.INTEGER));
			
			ConceptSchema locationSchema = (ConceptSchema) getSchema(LOCATION);
			locationSchema.add(ROW,
					(PrimitiveSchema) getSchema(BasicOntology.INTEGER));			
			locationSchema.add(COL,
					(PrimitiveSchema) getSchema(BasicOntology.INTEGER));

			PredicateSchema dirtSchema = (PredicateSchema) getSchema(DIRT);
			dirtSchema.add(IS_DIRT,
					(PrimitiveSchema) getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema inSchema = (PredicateSchema) getSchema(IN);
			inSchema.add(IS_AT,
					(PrimitiveSchema) getSchema(BasicOntology.BOOLEAN));
			
			PredicateSchema facingSchema = (PredicateSchema) getSchema(FACING);
			facingSchema.add(IS_FACING,
					(PrimitiveSchema) getSchema(BasicOntology.BOOLEAN));

			AgentActionSchema forwardSchema = (AgentActionSchema) getSchema(FORWARD);
			forwardSchema.add(FORWARD, (ConceptSchema)getSchema(VACUUM));
			
			AgentActionSchema suckSchema = (AgentActionSchema) getSchema(SUCK);
			suckSchema.add(SUCK, (ConceptSchema)getSchema(LOCATION));
			
			AgentActionSchema turnSchema = (AgentActionSchema) getSchema(TURN);
			turnSchema.add(TURN, (ConceptSchema)getSchema(VACUUM));

		} catch (OntologyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
