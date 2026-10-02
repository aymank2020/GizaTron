package com.example.android.gizatron;

public final class OpeningHoursCheck {
    public static void main(String[] args) {
        check(OpeningHours.isOpen(22, 2, 23), "before midnight");
        check(OpeningHours.isOpen(22, 2, 1), "after midnight");
        check(OpeningHours.isOpen(22, 2, 22), "opening boundary");
        check(!OpeningHours.isOpen(22, 2, 2), "closing boundary");
        check(!OpeningHours.isOpen(22, 2, 12), "overnight daytime closed");
        check(OpeningHours.isOpen(9, 17, 9), "day opening boundary");
        check(!OpeningHours.isOpen(9, 17, 17), "day closing boundary");
        check(OpeningHours.isOpen(0, 24, 0), "24 hour midnight");
        check("12:00 AM".equals(OpeningHours.formatTime(24)), "24 wraps to midnight");
        check("12:00 PM".equals(OpeningHours.formatTime(12)), "noon");
        check("9:05 AM".equals(OpeningHours.formatTime(9 + 5f / 60)), "minute padding and rounding");
        System.out.println("11 opening-hours checks passed");
    }

    private static void check(boolean condition, String label) {
        if (!condition) throw new AssertionError(label);
    }
}
