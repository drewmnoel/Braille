package player;

/**
 * Abstract representation of an event in the scenario. 
 * Events are created by FileParser parsing an input file
 *
 * @author Dilshad Khatri, Alvis Koshy, Drew Noel, Jonathan Tung
 * @version 1.0
 * @since 2017-02-12
 *
 */
public class Event {
	//Attributes to identify kind of event
	//Text to speech
	private static final long TTS = 0;
	private static final long AUDIO_PLAY = 1;
	private static final long BRAILLE = 2;
	//wait for button input
	private static final long BUTTON_INPUT = 3;
	//Jump to a specified event instead of continuing sequentially
	private static final long JUMP = 4;
	//Initialize the simulator with set number of buttons and cells
	private static final long INITIALIZE_SIM = 5;
	private long type;
	private String eventDetails;

	/**
	 * Create a blank event
	 */
	public Event() {
	}

	/**
	 * Set the event type to be Initialize Sim
	 * 
	 * @param cellsAndButtons 
	 * 		String containing number of cells whitespace number of buttons 
	 */
	public void setInitializeSim(String cellsAndButtons) {
		this.type = Event.INITIALIZE_SIM;
		this.eventDetails = cellsAndButtons;
	}
	
	/**
	 * Check if the event type is Initialize Sim
	 *
	 * @return True only if the event is Initialize Sim
	 */
	public boolean isInitializeSim() {
		return this.type == Event.INITIALIZE_SIM;
	}
	
	/**
	 * Set the event type to be TTS
	 *
	 * @param textToRead
	 *            Relevant text to be read aloud
	 */
	public void setTTS(String textToRead) {
		this.type = Event.TTS;
		this.eventDetails = textToRead;
	}

	/**
	 * Check if the event type is TTS
	 *
	 * @return True only if the event is TTS
	 */
	public boolean isTTS() {
		return this.type == Event.TTS;
	}

	/**
	 * Set the event type to be Audio Play
	 *
	 * @param filename
	 *            Path (relative or absolute) to the file to be played
	 */
	public void setAudioPlay(String filename) {
		this.type = Event.AUDIO_PLAY;
		this.eventDetails = filename;
	}

	/**
	 * Check if the event is an Audio Play
	 *
	 * @return True only if the event is an Audio Play
	 */
	public boolean isAudioPlay() {
		return this.type == Event.AUDIO_PLAY;
	}
	
	/**
	 * Set the event to be Set Braille
	 * 
	 * @param wordToSet
	 * 			String to represent on braille cells
	 */
	public void setBraille(String wordToSet) {
		this.type = Event.BRAILLE;
		this.eventDetails = wordToSet;
	}
	
	/**
	 * Check if the event is a Set Braille
	 * 
	 * @return True only if event is a Set Braille
	 */
	public boolean isSetBraille() {
		return this.type == Event.BRAILLE;
	}
	
	/**
	 * Set the event to be button input
	 * 
	 * @param button 
	 * 			Button number to expect a push from
	 */
	public void setButtonInput(String button) {
		this.type = Event.BUTTON_INPUT;
		this.eventDetails = button;
	}
	
	/**
	 * Check if the event is a button input
	 * 
	 * @return True only if event is a single buttonn
	 */
	public boolean isBUttonInput() {
		return this.type == Event.BUTTON_INPUT;
	}
	
	/**
	 * Returns a long representing the type of this event
	 * 
	 * @return 0 if TTS, 1 if audio play, 2 if set braille cell, 3 if wait for button push, 4 if jump event, 5 for initialize sim
	 */
	public long eventType() {
		return this.type;
	}
	
	/**
	 * Get the generic details parameter
	 *
	 * @return Event details. Meaning depends on the event type.
	 */
	public String getEventDetails() {
		return this.eventDetails;
	}
}