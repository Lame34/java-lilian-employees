package com.poo.partie1.gestionemployes;
import java.util.ArrayList;

public class Main {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {

        employees.add(new Employee("MA0001", "ALBERT", "NIELSON", "Directeur", 2000, 120000));
        employees.add(new Employee("MA0002", "MALIK", "YOAN", "Chef de service", 2001, 55000));
        employees.add(new Employee("MA0003", "VINCENT", "GOGH", "Informaticien", 2002, 40000));
        employees.add(new Employee("MA0004", "YOURI", "DODO", "Chef de service", 2003, 45000));
        employees.add(new Employee("MA0005", "NAEL", "MILES", "Informaticien", 2004, 45000));
        employees.add(new Employee("MA0006", "BOLAN", "KIKI", "Comptable", 2005, 45000));
        employees.add(new Employee("MA0007", "DOVER", "LOUIK", "Chef de service", 2006, 45000));
        employees.add(new Employee("MA0008", "KLIENS", "LYBE", "Informaticien", 2007, 35000));
        employees.add(new Employee("MA0009", "SIKA", "NIYLE", "Informaticien", 2008, 35000));
        employees.add(new Employee("MA0010", "JEAN", "DE DIEU", "Manager", 2009, 60000));
        employees.add(new Employee("MA0011", "DIANE", "SHUR", "CTO", 2010, 70000));


        // Q1 : Créer et afficher la liste des employés
        System.out.println("Liste des employés :");
        displayList(employees);


        // Q3 : Rechercher un employé par matricule
        System.out.println("\nRecherche par matricule :");
        System.out.println("MA0007 : " + findEmployeeById("MA0007")); 
        System.out.println("MAAGG7 : " + findEmployeeById("MAAGG7"));


        // Q4 : Afficher les employés embauchés en 2008
        System.out.println("\nEmbauchés en 2008 :");
        displayByStartYear(2008);


        // Q5 : Calcul de la masse salariale totale
        System.out.println("\nMasse salariale totale :");
        int totalPayroll = 0;
        for (Employee e : employees) {
            totalPayroll += e.getSalary();
        }
        System.out.println("Total : " + totalPayroll);


        // Q6 : Les salariés les plus anciens
        System.out.println("\nEmployés les plus anciens :");
        int minYear = 3000;
        for (Employee e : employees) {
            if (e.getStartYear() < minYear) minYear = e.getStartYear();
        }
        displayByStartYear(minYear);


        // Q7 : Afficher le salaire le plus bas de l'entreprise
        System.out.println("\nSalaire le plus bas :");
        int minSalary = Integer.MAX_VALUE;
        for (Employee e : employees) {
            if (e.getSalary() < minSalary) minSalary = e.getSalary();
        }
        System.out.println("Salaire Min : " + minSalary);


        // Q8 : Afficher les salariés ayant le salaire le plus bas
        System.out.println("\nEmployés avec le salaire min :");
        for (Employee e : employees) {
            if (e.getSalary() == minSalary) System.out.println(e);
        }


        // Q9 : Ajouter 550 aux salariés ayant le salaire le plus bas
        System.out.println("\nAjout salaire +550 :");
        for (Employee e : employees) {
            if (e.getSalary() == minSalary) {
                e.setSalary(e.getSalary() + 550);
                System.out.println("Mis à jour : " + e.getId());
            }
        }


        // Q10 : Afficher les informaticiens
        System.out.println("\nListe des informaticiens :");
        ArrayList<Employee> itengineer = getEmployeesByJob("Informaticien");
        displayList(itengineer);


        // Q11 : Total des salaires alloués aux Chefs de service
        System.out.println("\nTotal Salaire (Chef de service) :");
        int totalManagers = 0;
        for (Employee e : employees) {
            if (e.getJobTitle().equalsIgnoreCase("Chef de service")) totalManagers += e.getSalary();
        }
        System.out.println("Total : " + totalManagers);


        // Q12 : Compter le nombre de Chefs de service
        System.out.println("\nNombre de Chefs de service :");
        int countManagers = 0;
        for (Employee e : employees) {
            if (e.getJobTitle().equalsIgnoreCase("Chef de service")) countManagers++;
        }
        System.out.println("Compteur : " + countManagers);


        // Q13 : Écrire une méthode qui retourne la liste des Chefs de service
        System.out.println("\nListe des Chefs de service :");
        ArrayList<Employee> managers = getEmployeesByJob("Chef de service");
        displayList(managers);


        // Q14 : Filtre 5 ans d'ancienneté...
        System.out.println("\nFiltre :");
        for (Employee e : employees) {
            int seniority = 2020 - e.getStartYear();
            if (seniority > 5 && e.getSalary() > 15000 && e.getSalary() < 60000) {
                System.out.println(e + " (Ancienneté : " + seniority + " ans)");
            }
        }
    }


    // Méthodes utilitaires:

    // Affichage d'une liste
    public static void displayList(ArrayList<Employee> list) {
        for (Employee e : list) {
            System.out.println(e);
        }
    }


    // Rechercher un employé par matricule
    public static Employee findEmployeeById(String id) {
        for (Employee e : employees) {
            if (e.getId().equalsIgnoreCase(id)) return e;
        }
        return null;
    }


    // Afficher par année de début
    public static void displayByStartYear(int year) {
        for (Employee e : employees) {
            if (e.getStartYear() == year) System.out.println(e);
        }
    }


    // Obtenir une liste par poste
    public static ArrayList<Employee> getEmployeesByJob(String jobTitle) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getJobTitle().equalsIgnoreCase(jobTitle)) result.add(e);
        }
        return result;
    }
}
