package modelTests;
import model.Conference;
import model.ConferenceController;
import org.junit.Test;
import view.RoleView;
import view.SubView;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import static org.junit.Assert.*;

/**
 * @author Daniel
 * @version 2.0
 */
public class ConferenceControllerTest {
	private ZonedDateTime timeNow = ZonedDateTime.now();
    private Conference conference1 = new Conference("The first Conference", timeNow);
	private Conference conference2;
	private ConferenceController controller;



	/**
	 * Constructor that sets up the class.
	 */
	public ConferenceControllerTest() {
        ZonedDateTime timeOther = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        conference2 = new Conference("The second Conference", timeOther);
    }

	// [MethodName_StateUnderTest_ExpectedBehavior]

	/**
	 * Testing attempt to getCurrentConference() when no current Conference is set.
	 */
	@Test
	public void getCurrentConference_CurrentConferenceNotInitiated_ReturnsNull() {
		controller = new ConferenceController();
		assertNull("Conference Controller not initiated", controller.getCurrentConference());
	}

	/**
	 * Testing attempt to getCurrentConference() when no current Conference is set.
	 */
	@Test
	public void setCurrentConference_SettingAConference_ReturnsConference() {
		controller = new ConferenceController();
		controller.setCurrentConference(conference1);
		assertEquals("Didnt return correct Conference.", controller.getCurrentConference(), conference1);
	}

	/**
	 * Testing attempt to getCurrentConference() when no current Conference is set.
	 */
	@Test
	public void setCurrentConference_ChangeCurrentConference_ReturnsNewConference() {
		controller = new ConferenceController();
		controller.addConference(conference2);
		controller.setCurrentConference(conference1);
		assertEquals("Didnt return correct Conference.", controller.getCurrentConference(), conference1);
		controller.setCurrentConference(conference2);
		assertEquals("Didnt return correct Conference.", controller.getCurrentConference(), conference2);
	}
	/**
	 * Testing attempt to getCurrentConference() when no current Conference is set.
	 * @throws java.lang.IllegalArgumentException - throws exception
	 */
	@Test (expected = IllegalArgumentException.class)
	public void setCurrentConference_passInNullConference_ThrowsException() {
		controller = new ConferenceController();
		controller.setCurrentConference(null);
	}

	/**
	 * Testing the setCurrentConference() method with Integer Parameter.
	 */
	@Test
	public void setCurrentConference_IntegerRepresentationOfConference_ReturnsSpecifiedConferenceInArrayList() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		controller.setCurrentConference(0);
		assertEquals("Didnt return correct Conference.", controller.getCurrentConference(), conference1);
	}

	/**
	 * Testing attempt to setCurrentConference() with an out of bounds int parameter.
	 * @throws java.lang.IllegalArgumentException - throws exception
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void setCurrentConference_passInOutOfBoundsInt_ThrowsException()  {
		controller = new ConferenceController();
		controller.setCurrentConference(0);
		controller.setCurrentConference(100);
	}

	/**
	 * Testing attempt to getConference() with out of bounds int.
	 * @throws java.lang.IllegalArgumentException - throws exception
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void getConference_passTooSmallInt_ThrowsException() throws IndexOutOfBoundsException {
		controller = new ConferenceController();
		controller.addConference(conference1);
		controller.getConference(-1);
	}

	/**
	 * Testing attempt to getConference() with out of bounds int.
	 * @throws java.lang.IllegalArgumentException - throws exception
	 */
	@Test (expected = IndexOutOfBoundsException.class)
	public void getConference_passInTooLargeInt_ThrowsException() throws IndexOutOfBoundsException {
		controller = new ConferenceController();
		controller.addConference(conference1);
		controller.getConference(100);
	}

	/**
	 * Testing attempt to getCurrentConference() when no current Conference is set.
	 */
	@Test
	public void getConference_passInInt_GetConferenceAtRequestedLocation() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		controller.addConference(conference2);
		assertEquals("Returned Wrong Conference",controller.getConference(0), conference1);
		assertEquals("Returned Wrong Conference",controller.getConference(1), conference2);
	}

	/**
	 * Testing attempt to create a new conference without a proper name.
	 * @throws IllegalArgumentException when null is passed in.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNewConference_StringNameIsEmpty_ThrowsException() throws IllegalArgumentException {
		controller = new ConferenceController();
		controller.createNewConference("", timeNow);
	}

	/**
	 * Testing attempt to create a new conference without a proper name.
	 * @throws IllegalArgumentException when conference name is a null
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNewConference_StringNameIsNull_ThrowsException() throws IllegalArgumentException {
		controller = new ConferenceController();
		controller.createNewConference(null, timeNow);
	}

	/**
	 * Testing attempt to create a new conference without a proper date.
	 * @throws IllegalArgumentException when conference name is a null
	 */
	@Test (expected = IllegalArgumentException.class)
	public void createNewConference_DateIsNull_ThrowsException() {
		controller = new ConferenceController();
		controller.createNewConference("the Cool Kids Club", null);
	}

	/**
	 * Testing attempt to create a new conference.
	 */
	@Test
	public void createNewConference_ProperNameAndTime_ConferenceCreatedProperly() {
		controller = new ConferenceController();
		controller.createNewConference("The New Conference", timeNow);
		assertEquals("Conference not created Properly.", "The New Conference", controller.getConference(0).getMyConferenceName());
	}

	/**
	 * Testing attempt to create a add conference that is null.
	 * @throws IllegalArgumentException when conference is null
	 */
	@Test (expected = IllegalArgumentException.class)
	public void addConference_PassInNullConference_ThrowsException() {
		controller = new ConferenceController();
		controller.addConference(null);
	}

	/**
	 * Testing attempt to create and add a Conference.
	 */
	@Test
	public void addConference_LegitConference_CreatedSuccessfully() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		assertEquals("Conference was not added properly", controller.getConference(0), conference1);
	}

	/**
	 * Testing attempt to get number of conferences.
	 */
	@Test
	public void getNumberOfConferences_PassInTwoConferences_ReturnSizeIsTwo() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		controller.addConference(conference2);
		assertEquals("Didnt return right number of conferences", controller.getNumberOfConferences(), 2);
	}

	/**
	 * Testing attempt to search for a conference.
	 */
	@Test
	public void containsConference_PassInConferenceOne_TrueWhenSearchingForConferenceOneFalseForConferenceTwo() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		assertTrue("Couldnt find the conference", controller.containsConference("The first Conference"));
		assertFalse("Found non-existing conference", controller.containsConference("No Conference Here"));
	}


	/**
	 * Testing searchForConference() method while passing in a null.
	 * @throws IllegalArgumentException when Parameter is Null
	 */
	@Test (expected = IllegalArgumentException.class)
	public void searchForConference_PassInNull_ThrowsException() throws IllegalArgumentException {
		controller = new ConferenceController();
		controller.searchForConference(null);
	}

	/**
	 * Testing setRoleView() method, attempting to set a role view.
	 */
	@Test
	public void setRoleView_setARoleView_RoleViewSet() {
		RoleView view = new SubView(conference1, "Bob");
		controller = new ConferenceController();
		controller.setRoleView(view);
		assertEquals("Role view not set properly", controller.getRoleView(), view);
	}

	/**
	 * Testing isRoleViewSet() with no view set.
	 */
	@Test
	public void isRoleViewSet_NoViewSet_False() {
		controller = new ConferenceController();
		assertFalse("Roleview must be False", controller.isRoleViewSet());

	}

	/**
	 * Testing isRoleViewSet() with a set View.
	 */
	@Test
	public void isRoleViewSet_ViewSet_True() {
		RoleView view = new SubView(conference1, "Bob");
		controller = new ConferenceController();
		controller.setRoleView(view);
		assertTrue("Roleview must be Set!", controller.isRoleViewSet());
	}

	/**
	 * testing removeAllConferences() method.
	 */
	@Test
	public void removeAllConferences_removalOfConferences_SizeEqualsZero() {
		controller = new ConferenceController();
		controller.addConference(conference1);
		assertEquals("didnt add conference Properly", controller.getNumberOfConferences(), 1);
		controller.removeAllConferences();
		assertEquals("didnt remove conferences properly", controller.getNumberOfConferences(), 0);
	}

	/**
	 * Testing isConferenceSet() method with no conferences set.
	 */
	@Test
	public void isConferenceSet_NoConferenceSet_False() {
		controller = new ConferenceController();
		assertFalse("Conference is Set", controller.isConferenceSet());

	}

    /**
     * Testing isConferenceSet() method with a conferences set.
     */
    @Test
    public void isConferenceSet_ConferenceSet_True() {
        controller = new ConferenceController();
        controller.setCurrentConference(conference1);
        assertTrue("Conference is NotSet", controller.isConferenceSet());

    }

    /**
     * Testing isConferenceListEmpty() method with no conferences in list.
     *
     */
	@Test
	public void isConferenceListEmpty_NoConferencesAdded_True() {
	    controller = new ConferenceController();
	    assertTrue("No conferences added yet!", controller.isConferenceListEmpty());
	}


    /**
     * Testing isConferenceListEmpty() method with no conferences in list.
     *
     */
    @Test
    public void isConferenceListEmpty_ConferencesAdded_False() {
        controller = new ConferenceController();
        controller.addConference(conference1);
        assertFalse("Conferences added!", controller.isConferenceListEmpty());
    }
}