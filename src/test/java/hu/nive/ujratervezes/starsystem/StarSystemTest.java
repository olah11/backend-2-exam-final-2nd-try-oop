package hu.nive.ujratervezes.starsystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StarSystemTest {
    private List<Star> createSingleStar(){
        return new ArrayList<Star>(){{
            add(new Star("id1", StarCategory.GIANT));
        }};
    }

    private List<Star> createMultipleStars(){
        return new ArrayList<Star>(){{
            add(new Star("id1", StarCategory.DWARF));
            add(new Star("id2", StarCategory.GIANT));
            add(new Star("id3", StarCategory.GIANT));
            add(new Star("id4", StarCategory.GIANT));
            add(new Star("id5", StarCategory.GIANT));
            add(new Star("id6", StarCategory.SUPER_GIANT));
            add(new Star("id7", StarCategory.SUPER_GIANT));
        }};
    }

    private List<Planet> createPlanets(){
        return new ArrayList<Planet>(){{
           add(new Planet("id1",PlanetCategory.SMALL));
           add(new Planet("id2",PlanetCategory.SMALL));
           add(new Planet("id3",PlanetCategory.BIG));
           add(new Planet("id4",PlanetCategory.BIG));
           add(new Planet("id5",PlanetCategory.BIG));
        }};
    }

    @Test
    void test_getPlanetCategory(){
        Planet planet = new Planet("id1", PlanetCategory.BIG);
        assertEquals(PlanetCategory.BIG, planet.getPlanetCategory());
    }

    @Test
    void test_planetIsStarSystemObject(){
        Planet planet = new Planet("id1", PlanetCategory.SMALL);
        assertTrue(planet instanceof StarSystemObject);
    }

    @Test
    void test_getStarCategory(){
        Star star = new Star("id1",StarCategory.GIANT);
        assertEquals(StarCategory.GIANT, star.getStarCategory());
    }

    @Test
    void test_setStarCategory(){
        Star star = new Star("id1",StarCategory.GIANT);
        star.setStarCategory(StarCategory.DWARF);
        assertEquals(StarCategory.DWARF, star.getStarCategory());
    }

    @Test
    void test_startIsStarSystemObject(){
        Star star = new Star("id",StarCategory.SUPER_GIANT);
        assertTrue(star instanceof StarSystemObject);
    }

    @Test
    void test_getId_worksForStar(){
        Star star = new Star("expectedid1",StarCategory.SUPER_GIANT);
        assertEquals("expectedid1", star.getId());
    }

    @Test
    void test_getId_worksForPlanet(){
        Planet planet = new Planet("expectedid1",PlanetCategory.BIG);
        assertEquals("expectedid1", planet.getId());
    }

    @Test
    void test_getPlanets(){
        List<Planet> planets = createPlanets();
        List<Star> stars = createSingleStar();
        StarSystem starSystem = new StarSystem(planets,stars);
        assertEquals(planets,starSystem.getPlanets());
    }

    @Test
    void test_getStars(){
        List<Planet> planets = createPlanets();
        List<Star> stars = createSingleStar();
        StarSystem starSystem = new StarSystem(planets,stars);
        assertEquals(stars,starSystem.getStars());
    }

    @Test
    void test_filterPlanetCategory(){
        Planet planet1 = new Planet("1", PlanetCategory.BIG);
        Planet planet2 = new Planet("2", PlanetCategory.BIG);
        Planet planet3 = new Planet("3", PlanetCategory.SMALL);
        List<Planet> planets = new ArrayList<Planet>(){{
            add(planet1);
            add(planet2);
            add(planet3);
        }};
        List<Planet> expectedPlanets = new ArrayList<Planet>(){{
            add(planet1);
            add(planet2);
        }};
        List<Star> stars = createSingleStar();
        StarSystem starSystem = new StarSystem(planets,stars);
        List<Planet> actual = starSystem.filterPlanetCategory(PlanetCategory.BIG);
        assertThat(actual).hasSameElementsAs(expectedPlanets);
    }

    @Test
    void test_hasMultipleStar(){
        List<Star> stars = createMultipleStars();
        List<Star> starsForSingle = createSingleStar();
        List<Planet> planets = createPlanets();
        StarSystem starSystem = new StarSystem(planets,stars);
        StarSystem singleStarSystem = new StarSystem(planets,starsForSingle);
        assertTrue(starSystem.hasMultipleStar() && !singleStarSystem.hasMultipleStar());
    }

    @Test
    void test_removeByPlanetCategory(){
        Planet planet1 = new Planet("1", PlanetCategory.BIG);
        Planet planet2 = new Planet("2", PlanetCategory.BIG);
        Planet planet3 = new Planet("3", PlanetCategory.SMALL);
        List<Planet> planets = new ArrayList<Planet>(){{
            add(planet1);
            add(planet2);
            add(planet3);
        }};
        List<Planet> expectedPlanets = new ArrayList<Planet>(){{
            add(planet1);
            add(planet2);
        }};
        List<Star> stars = createSingleStar();
        StarSystem starSystem = new StarSystem(planets,stars);
        starSystem.removeByPlanetCategory(PlanetCategory.SMALL);
        List<Planet> actual = starSystem.getPlanets();
        assertThat(actual).hasSameElementsAs(expectedPlanets);
    }

    @Test
    void test_countByStarCategory(){
        List<Star> stars = createMultipleStars();
        List<Planet> planets = createPlanets();
        StarSystem starSystem = new StarSystem(planets,stars);
        assertEquals(4, starSystem.countByStarCategory(StarCategory.GIANT));
    }
}