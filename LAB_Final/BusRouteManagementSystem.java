import java.util.*;

class BusRoute implements Comparable<BusRoute> {
    private int routeNumber;
    private String startPoint;
    private String endPoint;

    public BusRoute(int routeNumber, String startPoint, String endPoint) {
        this.routeNumber = routeNumber;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getRouteNumber() {
        return routeNumber;
    }

    public void setRouteNumber(int routeNumber) {
        this.routeNumber = routeNumber;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }


    public int compareTo(BusRoute other) {
        return Integer.compare(this.routeNumber, other.routeNumber);
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BusRoute)) return false;
        BusRoute other = (BusRoute) obj;
        return this.routeNumber == other.routeNumber;
    }

    public int hashCode() {
        return Integer.hashCode(routeNumber);
    }

    public String toString() {
        return "Route " + routeNumber + ": " + startPoint + " \u2192 " + endPoint;
    }
}

public class BusRouteManagementSystem {

    private static boolean addRoute(TreeSet<BusRoute> routes, Stack<BusRoute> recentlyAdded,
                                     BusRoute route) {
        boolean added = routes.add(route);
        if (added) {
            recentlyAdded.push(route);
        }
        return added;
    }

    private static BusRoute findRoute(TreeSet<BusRoute> routes, int routeNumber) {
        for (BusRoute route : routes) {
            if (route.getRouteNumber() == routeNumber) {
                return route;
            }
        }
        return null;
    }

    private static BusRoute removeRoute(TreeSet<BusRoute> routes, int routeNumber) {
        BusRoute found = findRoute(routes, routeNumber);
        if (found != null) {
            routes.remove(found);
        }
        return found;
    }

    public static void main(String[] args) {
        
        TreeSet<BusRoute> routes = new TreeSet<>();
        Stack<BusRoute> recentlyAdded = new Stack<>();

        Object[][] inputData = {
            {101, "Dhanmondi", "Gulshan"},
            {105, "Mirpur", "Motijheel"},
            {103, "Uttara", "Mohakhali"},
            {110, "Farmgate", "Shyamoli"},
            {107, "Banani", "Jatrabari"},
            {103, "Uttara", "Airport"}
        };

        for (Object[] data : inputData) {
            int routeNumber = (Integer) data[0];
            String startPoint = (String) data[1];
            String endPoint = (String) data[2];
            BusRoute route = new BusRoute(routeNumber, startPoint, endPoint);

            boolean added = addRoute(routes, recentlyAdded, route);
            if (!added) {
                System.out.println("Route " + routeNumber + " already exists. Route was not added.");
            }
        }

        System.out.println("\nAvailable Bus Routes (Sorted):");
        for (BusRoute route : routes) {
            System.out.println(route);
        }

        int searchNumber = 107;
        System.out.println("\nSearching for Route " + searchNumber + ":");
        BusRoute searchResult = findRoute(routes, searchNumber);
        if (searchResult != null) {
            System.out.println(searchResult);
        } else {
            System.out.println("Route " + searchNumber + " not found.");
        }

        int removeNumber = 105;
        System.out.println("\nRemoving Route " + removeNumber + ":");
        BusRoute removed = removeRoute(routes, removeNumber);
        if (removed != null) {
            System.out.println(removed);
        } else {
            System.out.println("Route " + removeNumber + " not found. Nothing removed.");
        }

        System.out.println("\nMost Recently Added Route (Stack Pop):");
        if (!recentlyAdded.isEmpty()) {
            BusRoute popped = recentlyAdded.pop();
            System.out.println(popped);
        } else {
            System.out.println("No routes in the stack.");
        }


        System.out.println("\nRemaining Routes in Stack:");
        if (recentlyAdded.isEmpty()) {
            System.out.println("(none)");
        } else {
            ListIterator<BusRoute> it = recentlyAdded.listIterator(recentlyAdded.size());
            while (it.hasPrevious()) {
                System.out.println(it.previous());
            }
        }
    }
}