package ipbhalle.de.enzymeml.model;

/**
 *
 * @author Fabian Mauz (fmauz@ipb-halle.de)
 */
public enum UnitType {
    AMPERE("ampere"),
    AVOGADRO("avogadro"),
    BECQUEREL("becquerel"),
    CANDELA("candela"),
    CELSIUS("celsius"),
    COULOMB("coulomb"),
    DIMENSIONLESS("dimensionless"),
    FARAD("farad"),
    GRAM("gram"),
    GRAY("gray"),
    HENRY("henry"),
    HERTZ("hertz"),
    ITEM("item"),
    JOULE("joule"),
    KATAL("katal"),
    KELVIN("kelvin"),
    KILOGRAM("kilogram"),
    LITRE("litre"),
    LUMEN("lumen"),
    LUX("lux"),
    METRE("metre"),
    MOLE("mole"),
    NEWTON("newton"),
    OHM("ohm"),
    PASCAL("pascal"),
    RADIAN("radian"),
    SECOND("second"),
    SIEMENS("siemens"),
    SIEVERT("sievert"),
    STERADIAN("steradian"),
    TESLA("tesla"),
    VOLT("volt"),
    WATT("watt"),
    WEBER("weber");

    private String name;

    private UnitType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
