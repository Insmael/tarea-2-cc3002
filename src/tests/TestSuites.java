package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({ CardCreationTest.class, ICardPilesManagerTest.class, ICardPileTest.class, IDeckStrategyTest.class,
		IPlayerTest.class, IPlayerListBuilderTest.class, CGameLogicTest.class })

public class TestSuites {

}
