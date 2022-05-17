package tries;

import org.junit.Test;

interface Employee {
    void say();
}

class SalesConsultant implements Employee {
    public void say() {
        System.out.println("I am SalesConsultant");
    }
}

class Accountant implements Employee {
    public void say() {
        System.out.println("I am Acountant");
    }
};

class Janitor implements Employee {
    public void say() {
        System.out.println("I am Janitor");
    }
};

class Electrician implements Employee {
    public void say() {
        System.out.println("I am Electrician");
    }
};

interface AbstractFactory {
    Employee getEmployee(String s);
}

class OfficeFactory implements AbstractFactory {
    public Employee getEmployee(String s) {
        if (s.equals("SC")) {
            return new SalesConsultant();
        } else if (s.equals("AC")) {
            return new Accountant();
        } else return null;
    }
}

class LabourFactory implements AbstractFactory {
    public Employee getEmployee(String s) {
        if (s.equals("JN")) {
            return new Janitor();
        } else if (s.equals("EL")) {
            return new Electrician();
        } else return null;
    }
}

class FactoryProducer {
    AbstractFactory getFactory(String officeOrLabour) {
        if (officeOrLabour.equals("OFF")) {
            return new OfficeFactory();
        } else if (officeOrLabour.equals("LAB")) {
            return new LabourFactory();
        } else return null;
    }
}


public class AbstractFactoryTry {
    @Test
    public void method() {
        AbstractFactory off = new FactoryProducer().getFactory("OFF");
        AbstractFactory lab = new FactoryProducer().getFactory("LAB");
        Employee accountant = off.getEmployee("AC");
        Employee sales = off.getEmployee("SC");
        Employee electrician = lab.getEmployee("EL");
        Employee janitor = lab.getEmployee("JN");
        janitor.say();
        sales.say();
        accountant.say();
        electrician.say();


    }
}
