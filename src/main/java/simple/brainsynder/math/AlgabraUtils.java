package simple.brainsynder.math;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AlgabraUtils {
    public static TreeSet<String> sortKey(Set<String> toSort) {
        TreeSet sortedSet = new TreeSet();
        Iterator i$ = toSort.iterator();

        while(i$.hasNext()) {
            String cur = (String)i$.next();
            sortedSet.add(cur);
        }

        return sortedSet;
    }

    public static Vector getTrajectory(Entity from, Entity to) {
        return getTrajectory(from.getLocation().toVector(), to.getLocation().toVector());
    }

    public static Vector getTrajectory(Location from, Location to) {
        return getTrajectory(from.toVector(), to.toVector());
    }

    public static Vector getTrajectory(Vector from, Vector to) {
        return to.subtract(from).normalize();
    }

    public static Vector getTrajectory2d(Entity from, Entity to) {
        return getTrajectory2d(from.getLocation().toVector(), to.getLocation().toVector());
    }

    public static Vector getTrajectory2d(Location from, Location to) {
        return getTrajectory2d(from.toVector(), to.toVector());
    }

    public static Vector getTrajectory2d(Vector from, Vector to) {
        return to.subtract(from).setY(0).normalize();
    }

    public static float getPitch(Vector vec) {
        double x = vec.getX();
        double y = vec.getY();
        double z = vec.getZ();
        double xz = Math.sqrt(x * x + z * z);
        double pitch = Math.toDegrees(Math.atan(xz / y));
        if(y <= 0.0D) {
            pitch += 90.0D;
        } else {
            pitch -= 90.0D;
        }

        return (float)pitch;
    }

    public static float getYaw(Vector vec) {
        double x = vec.getX();
        double z = vec.getZ();
        double yaw = Math.toDegrees(Math.atan(-x / z));
        if(z < 0.0D) {
            yaw += 180.0D;
        }

        return (float)yaw;
    }

    public static Vector normalize(Vector vec) {
        if(vec.length() > 0.0D) {
            vec.normalize();
        }

        return vec;
    }

    public static Vector clone(Vector vec) {
        return new Vector(vec.getX(), vec.getY(), vec.getZ());
    }

    public static <T> T random(List<T> list) {
        return list.get(MathUtils.r(list.size()));
    }
}
