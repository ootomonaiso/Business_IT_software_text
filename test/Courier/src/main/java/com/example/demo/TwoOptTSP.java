package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Point {
    int id;
    double x;
    double y;
    int customerId;

    public Point(int id, double x, double y, int customerId) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.customerId = customerId;
    }
}

public class TwoOptTSP {

    public static List<Point> findOptimalRoute(List<Point> points) {
        List<Point> currentRoute = new ArrayList<>(points);

        int size = currentRoute.size();
        List<Point> newRoute;
        boolean improvement = true;

        while (improvement) {
            improvement = false;
            for (int i = 0; i < size - 1; i++) {
                for (int j = i + 1; j < size; j++) {
                    newRoute = twoOptSwap(currentRoute, i, j);
                    double currentDistance = calculateTotalDistance(currentRoute);
                    double newDistance = calculateTotalDistance(newRoute);
                    if (newDistance < currentDistance) {
                        currentRoute = newRoute;
                        improvement = true;
                    }
                }
            }
        }

        // Rotate the route again so that point with id:1 is at the beginning
        int startIdx = 0;
        for (int j = 0; j < currentRoute.size(); j++) {
            if (currentRoute.get(j).id == 1) {
                startIdx = j;
                break;
            }
        }
        Collections.rotate(currentRoute, startIdx);

        return currentRoute;
    }

    public static List<Point> twoOptSwap(List<Point> route, int i, int j) {
        List<Point> newRoute = new ArrayList<>(route.subList(0, i));
        for (int k = j; k >= i; k--) {
            newRoute.add(route.get(k));
        }
        for (int k = j + 1; k < route.size(); k++) {
            newRoute.add(route.get(k));
        }
        return newRoute;
    }

    public static double calculateTotalDistance(List<Point> route) {
        double totalDistance = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            Point currentPoint = route.get(i);
            Point nextPoint = route.get(i + 1);
            double distance = Math.sqrt(Math.pow(nextPoint.x - currentPoint.x, 2) +
                    Math.pow(nextPoint.y - currentPoint.y, 2));
            totalDistance += distance;
        }
        return totalDistance;
    }
}
