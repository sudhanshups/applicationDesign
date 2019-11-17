package pattern.builder;


abstract class AircraftBuilder {

    public void buildEngine() {
    }

    public void buildWings() {
    }

    public void buildCockpit() {
    }

    public void buildBathrooms() {
    }

    abstract public IAircraft getResult();
}

class Boeing747Builder extends AircraftBuilder {

    Boeing747 boeing747;

    @Override
    public void buildCockpit() {
    }

    @Override
    public void buildEngine() {
    }

    @Override
    public void buildBathrooms() {
    }

    @Override
    public void buildWings() {
    }

    public IAircraft getResult() {
        return boeing747;
    }
}

class F16Builder extends AircraftBuilder {
    F16 f16;
    @Override
    public void buildEngine() {
        // get F-16 an engine
        // f16.engine = new F16Engine();
    }

    @Override
    public void buildWings() {
        // get F-16 wings
        // f16.wings = new F16Wings();
    }

    @Override
    public void buildCockpit() {
        f16 = new F16();
        // get F-16 a cockpit
        // f16.cockpit = new F16Cockpit();
    }

    public IAircraft getResult() {
        return f16;
    }
}


