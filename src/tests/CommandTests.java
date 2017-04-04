package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import commands.*;

/***
 * JUnit test cases for all the various command classes
 *
 */

public class CommandTests {

	/**
	 * Sets up instances of all the command classes
	 */
	CellCharCommand cellChar;
	CellLowerCommand cellLower;
	CellRaiseCommand cellRaise;
	ClearAllCommand clearAll;
	ClearCellCommand clearCell;
	GoHereCommand goHere;
	PauseCommand pause;
	RepeatButtonCommand repeatButton;
	RepeatCommand repeat;
	ResetButtonCommand resetButton;
	SetPinsCommand setPins;
	SetStringCommand setString;
	SetVoiceCommand setVoice;
	SkipButtonCommand skipButton;
	SkipCommand skip;
	SoundCommand sound;
	TTSCommand TTS;
	UserInputCommand userInput;
	

	@Before
	public void setUp() throws Exception {
		
	}
	
	/**
	 * Tests all the methods in CellCharCommand 
	 */
	@Test
	public void testCellCharCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			cellChar = new CellCharCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Cell and Char: " + i + " " + alphabet.substring(i, i), cellChar.toString());
		}
		cellChar = new CellCharCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Cell and Char: This is a very long string look how long this is bork bork bork bork bork!", cellChar.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			cellChar = new CellCharCommand(i + " " + alphabet.substring(i, i));
			assertEquals("/~disp-cell-char:" + i + " " + alphabet.substring(i, i), cellChar.serialize());
		}
		cellChar = new CellCharCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~disp-cell-char:This is a very long string look how long this is bork bork bork bork bork!", cellChar.serialize());
		
		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			cellChar = new CellCharCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Cell and character (space separated)", cellChar.getEditLabel());
		}
		
		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			cellChar = new CellCharCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), cellChar.getCurrentValue());
		}
		
		//tests setCurrentValue()
		cellChar = new CellCharCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			cellChar.setCurrentValue(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), cellChar.getCurrentValue());
		}
	}
	
	/**
	 * Tests all the methods in CellLowerCommand
	 */
	@Test
	public void testCellLowerCommand() {
	
		//tests toString()
		for(int i = 0; i<26; i++) {
			cellLower = new CellLowerCommand(i + " " + i);
			assertEquals("Cell and Pin Lower: " + i + " " + i, cellLower.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			cellLower = new CellLowerCommand(i + " " + i);
			assertEquals("/~disp-cell-lower:" + i + " " + i, cellLower.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			cellLower = new CellLowerCommand(i + " " + i);
			assertEquals("Cell and Pin to lower (space separated)", cellLower.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			cellLower = new CellLowerCommand(i + " " + i);
			assertEquals(i + " " + i, cellLower.getCurrentValue());
		}

		//tests setCurrentValue()
		cellLower = new CellLowerCommand(" ");
		for(int i = 0; i<26; i++) {
			cellLower.setCurrentValue(i + " " + i);
			assertEquals(i + " " + i, cellLower.getCurrentValue());
		}
	}
	
	/**
	 * Tests all the methods in CellRaiseCommand
	 */
	@Test
	public void testCellRaiseCommand() {
	
		//tests toString()
		for(int i = 0; i<26; i++) {
			cellRaise = new CellRaiseCommand(i + " " + i);
			assertEquals("Cell and Pin Raise: " + i + " " + i, cellRaise.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			cellRaise = new CellRaiseCommand(i + " " + i);
			assertEquals("/~disp-cell-raise:" + i + " " + i, cellRaise.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			cellRaise = new CellRaiseCommand(i + " " + i);
			assertEquals("Cell and Pin to raise (space separated)", cellRaise.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			cellRaise = new CellRaiseCommand(i + " " + i);
			assertEquals(i + " " + i, cellRaise.getCurrentValue());
		}

		//tests setCurrentValue()
		cellRaise = new CellRaiseCommand(" ");
		for(int i = 0; i<26; i++) {
			cellRaise.setCurrentValue(i + " " + i);
			assertEquals(i + " " + i, cellRaise.getCurrentValue());
		}
	}
	
	/**
	 * Tests all the methods in ClearAllCommand
	 */
	@Test
	public void testClearAllCommand() {
	
		clearAll = new ClearAllCommand("");
		//tests toString()
		assertEquals("Clear All", clearAll.toString());


		//tests serialize()
		assertEquals( "/~disp-clearAll", clearAll.serialize());


		//tests getEditLabel()
		assertEquals("Ignored", clearAll.getEditLabel());


		//tests getCurrentValue()
		assertEquals("", clearAll.getCurrentValue());
	}
	
	/**
	 * Test all methods in ClearCellCommand
	 */
	@Test
	public void testClearCellCommand() {
		//tests toString()
		for(int i = 0; i<26; i++) {
			clearCell = new ClearCellCommand(Integer.toString(i));
			assertEquals("Clear Cell " + i, clearCell.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			clearCell = new ClearCellCommand(Integer.toString(i));
			assertEquals("/~disp-clear-cell:" + i, clearCell.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			clearCell = new ClearCellCommand(Integer.toString(i));
			assertEquals("Cell number", clearCell.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			clearCell = new ClearCellCommand(Integer.toString(i));
			assertEquals(Integer.toString(i), clearCell.getCurrentValue());
		}

		//tests setCurrentValue()
		clearCell = new ClearCellCommand(" ");
		for(int i = 0; i<26; i++) {
			clearCell.setCurrentValue(Integer.toString(i));
			assertEquals(Integer.toString(i), clearCell.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in GoHereCommand
	 */
	@Test
	public void testGoHereCommand() {
		goHere = new GoHereCommand("testjumptaghere");
		//tests toString()
		assertEquals("Jump tag: testjumptaghere", goHere.toString());


		//tests serialize()
		assertEquals( "/~testjumptaghere", goHere.serialize());


		//tests getEditLabel()
		assertEquals("Enter name of jump tag", goHere.getEditLabel());


		//tests setCurrentValue()
		goHere.setCurrentValue("new tag");
		assertEquals("new tag", goHere.getCurrentValue());

	}
	
	/**
	 * Test all methods in PauseCommand
	 */
	@Test
	public void testPauseCommand() {
		//tests toString()
		for(int i = 0; i<26; i++) {
			pause = new PauseCommand(Integer.toString(i));
			assertEquals("Pause: " + Integer.toString(i), pause.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			pause = new PauseCommand(Integer.toString(i));
			assertEquals("/~pause:" + i, pause.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			pause = new PauseCommand(Integer.toString(i));
			assertEquals("Length of time to wait", pause.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			pause = new PauseCommand(Integer.toString(i));
			assertEquals(Integer.toString(i), pause.getCurrentValue());
		}

		//tests setCurrentValue()
		pause = new PauseCommand(" ");
		for(int i = 0; i<26; i++) {
			pause.setCurrentValue(Integer.toString(i));
			assertEquals(Integer.toString(i), pause.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in RepeatButtonCommand
	 */
	@Test
	public void testRepeatButtonCommand() {
		//tests toString()
		for(int i = 0; i<26; i++) {
			repeatButton = new RepeatButtonCommand(Integer.toString(i));
			assertEquals("Repeat Button: " + Integer.toString(i), repeatButton.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			repeatButton = new RepeatButtonCommand(Integer.toString(i));
			assertEquals("/~repeat-button:" + i, repeatButton.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			repeatButton = new RepeatButtonCommand(Integer.toString(i));
			assertEquals("Button to use for repeating", repeatButton.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			repeatButton = new RepeatButtonCommand(Integer.toString(i));
			assertEquals(Integer.toString(i), repeatButton.getCurrentValue());
		}

		//tests setCurrentValue()
		repeatButton = new RepeatButtonCommand(" ");
		for(int i = 0; i<26; i++) {
			repeatButton.setCurrentValue(Integer.toString(i));
			assertEquals(Integer.toString(i), repeatButton.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in RepeatCommand
	 */
	@Test
	public void testRepeatCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			repeat = new RepeatCommand(alphabet.substring(i, i));
			assertEquals("Repeat: " + alphabet.substring(i, i), repeat.toString());
		}
		repeat = new RepeatCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Repeat: This is a very long string look how long this is bork bork bork bork bork!", repeat.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			repeat = new RepeatCommand(alphabet.substring(i, i));
			assertEquals("/~repeat\n" + alphabet.substring(i, i) + "\n" + "/~endrepeat", repeat.serialize());
		}
		repeat = new RepeatCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~repeat\nThis is a very long string look how long this is bork bork bork bork bork!\n/~endrepeat", repeat.serialize());

		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			repeat = new RepeatCommand(alphabet.substring(i, i));
			assertEquals("Text to be repeated", repeat.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			repeat = new RepeatCommand(alphabet.substring(i, i));
			assertEquals(alphabet.substring(i, i), repeat.getCurrentValue());
		}

		//tests setCurrentValue()
		repeat = new RepeatCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			repeat.setCurrentValue(alphabet.substring(i, i));
			assertEquals(alphabet.substring(i, i), repeat.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in ResetButtonCommand 
	 */
	@Test
	public void testResetButtonCommand() {
		resetButton = new ResetButtonCommand("");
		//tests toString()
		assertEquals("Reset Buttons", resetButton.toString());


		//tests serialize()
		assertEquals( "/~reset-buttons", resetButton.serialize());


		//tests getEditLabel()
		assertEquals("Ignored", resetButton.getEditLabel());


		//tests getCurrentValue()
		assertEquals(null, resetButton.getCurrentValue());
	}
	
	/**
	 * Test all methods in SetPinsCommand
	 */
	@Test
	public void testSetPinsCommand() {
		//tests toString()
		for(int i = 0; i<26; i++) {
			setPins = new SetPinsCommand(i + " " + i);
			assertEquals("Set Pins: " + i + " " + i, setPins.toString());
		}

		//tests serialize()
		for(int i = 0; i<26; i++) {
			setPins = new SetPinsCommand(i + " " + i);
			assertEquals("/~disp-cell-pins:" + i + " " + i, setPins.serialize());
		}

		//tests getEditLabel()
		for(int i = 0; i<26; i++) {
			setPins = new SetPinsCommand(i + " " + i);
			assertEquals("Cell and pins (space separated)", setPins.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<26; i++) {
			setPins = new SetPinsCommand(i + " " + i);
			assertEquals(i + " " + i, setPins.getCurrentValue());
		}

		//tests setCurrentValue()
		setPins = new SetPinsCommand(" ");
		for(int i = 0; i<26; i++) {
			setPins.setCurrentValue(i + " " + i);
			assertEquals(i + " " + i, setPins.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in SetStringCommand
	 */
	@Test
	public void testSetStringCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			setString = new SetStringCommand(alphabet.substring(i, i));
			assertEquals("String: " + alphabet.substring(i, i), setString.toString());
		}
		setString = new SetStringCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("String: This is a very long string look how long this is bork bork bork bork bork!", setString.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			setString = new SetStringCommand(alphabet.substring(i, i));
			assertEquals("/~disp-string:" + alphabet.substring(i, i), setString.serialize());
		}
		setString = new SetStringCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~disp-string:This is a very long string look how long this is bork bork bork bork bork!", setString.serialize());

		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			setString = new SetStringCommand(alphabet.substring(i, i));
			assertEquals("String to display", setString.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			setString = new SetStringCommand(alphabet.substring(i, i));
			assertEquals(alphabet.substring(i, i), setString.getCurrentValue());
		}

		//tests setCurrentValue()
		setString = new SetStringCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			setString.setCurrentValue(alphabet.substring(i, i));
			assertEquals(alphabet.substring(i, i), setString.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in SetVoiceCommand
	 */
	@Test
	public void testSetVoiceCommand() {
		//tests toString()
		for(int i = 1; i<5; i++) {
			setVoice = new SetVoiceCommand(Integer.toString(i));
			assertEquals("Voice: " + i, setVoice.toString());
		}

		//tests serialize()
		for(int i = 1; i<5; i++) {
			setVoice = new SetVoiceCommand(Integer.toString(i));
			assertEquals("/~set-voice:" + i , setVoice.serialize());
		}

		//tests getEditLabel()
		for(int i = 1; i<5; i++) {
			setVoice = new SetVoiceCommand(Integer.toString(i));
			assertEquals("Enter a voice number", setVoice.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 1; i<5; i++) {
			setVoice = new SetVoiceCommand(Integer.toString(i));
			assertEquals(Integer.toString(i) , setVoice.getCurrentValue());
		}

		//tests setCurrentValue()
		setVoice = new SetVoiceCommand(" ");
		for(int i = 1; i<5; i++) {
			setVoice.setCurrentValue(Integer.toString(i) );
			assertEquals(Integer.toString(i) , setVoice.getCurrentValue());
		}
	}
	
	/** 
	 * Test all methods in SkipButtonCommand
	 */
	@Test
	public void testSkipButtonCommand () {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			skipButton = new SkipButtonCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Skip button: " + i + " " + alphabet.substring(i, i), skipButton.toString());
		}
		skipButton = new SkipButtonCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Skip button: This is a very long string look how long this is bork bork bork bork bork!", skipButton.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			skipButton = new SkipButtonCommand(i + " " + alphabet.substring(i, i));
			assertEquals("/~skip-button:" + i + " " + alphabet.substring(i, i), skipButton.serialize());
		}
		skipButton = new SkipButtonCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~skip-button:This is a very long string look how long this is bork bork bork bork bork!", skipButton.serialize());
		
		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			skipButton = new SkipButtonCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Button and identifier (space separated)", skipButton.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			skipButton = new SkipButtonCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), skipButton.getCurrentValue());
		}

		//tests setCurrentValue()
		skipButton = new SkipButtonCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			skipButton.setCurrentValue(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), skipButton.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in SkipCommand
	 */
	@Test
	public void testSkipCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			skip = new SkipCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Skip to: " + i + " " + alphabet.substring(i, i), skip.toString());
		}
		skip = new SkipCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Skip to: This is a very long string look how long this is bork bork bork bork bork!", skip.toString());

		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			skip = new SkipCommand(i + " " + alphabet.substring(i, i));
			assertEquals("/~skip:" + i + " " + alphabet.substring(i, i), skip.serialize());
		}
		skip = new SkipCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~skip:This is a very long string look how long this is bork bork bork bork bork!", skip.serialize());
		
		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			skip = new SkipCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Enter jump tag to skip to", skip.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			skip = new SkipCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), skip.getCurrentValue());
		}

		//tests setCurrentValue()
		skip = new SkipCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			skip.setCurrentValue(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), skip.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in SoundCommand
	 */
	@Test
	public void testSoundCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			sound = new SoundCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Sound: " + i + " " + alphabet.substring(i, i), sound.toString());
		}
		sound = new SoundCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Sound: This is a very long string look how long this is bork bork bork bork bork!", sound.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			sound = new SoundCommand(i + " " + alphabet.substring(i, i));
			assertEquals("/~sound:" + i + " " + alphabet.substring(i, i), sound.serialize());
		}
		sound = new SoundCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("/~sound:This is a very long string look how long this is bork bork bork bork bork!", sound.serialize());
		
		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			sound = new SoundCommand(i + " " + alphabet.substring(i, i));
			assertEquals("File path: ", sound.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			sound = new SoundCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), sound.getCurrentValue());
		}

		//tests setCurrentValue()
		sound = new SoundCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			sound.setCurrentValue(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), sound.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in TTSCommand
	 */
	@Test
	public void testTTSCommand() {
		//alphabet, valid inputs to test
		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		//tests toString()
		for(int i = 0; i<alphabet.length(); i++) {
			TTS = new TTSCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Text to speech: " + i + " " + alphabet.substring(i, i), TTS.toString());
		}
		TTS = new TTSCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("Text to speech: This is a very long string look how long this is bork bork bork bork bork!", TTS.toString());
		
		//tests serialize()
		for(int i = 0; i<alphabet.length(); i++) {
			TTS = new TTSCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), TTS.serialize());
		}
		TTS = new TTSCommand("This is a very long string look how long this is bork bork bork bork bork!");
		assertEquals("This is a very long string look how long this is bork bork bork bork bork!", TTS.serialize());
		
		//tests getEditLabel()
		for(int i = 0; i<alphabet.length(); i++) {
			TTS = new TTSCommand(i + " " + alphabet.substring(i, i));
			assertEquals("Text to say", TTS.getEditLabel());
		}

		//tests getCurrentValue()
		for(int i = 0; i<alphabet.length(); i++) {
			TTS = new TTSCommand(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), TTS.getCurrentValue());
		}

		//tests setCurrentValue()
		TTS = new TTSCommand(" ");
		for(int i = 0; i<alphabet.length(); i++) {
			TTS.setCurrentValue(i + " " + alphabet.substring(i, i));
			assertEquals(i + " " + alphabet.substring(i, i), TTS.getCurrentValue());
		}
	}
	
	/**
	 * Test all methods in UserInputCommand
	 */
	@Test
	public void testUserInputCommand() {
		userInput = new UserInputCommand();
		//tests toString()
		assertEquals("User Input", userInput.toString());


		//tests serialize()
		assertEquals( "/~user-input", userInput.serialize());


		//tests getEditLabel()
		assertEquals("Ignored", userInput.getEditLabel());


		//tests getCurrentValue()
		assertEquals(null, userInput.getCurrentValue());
	}
}
