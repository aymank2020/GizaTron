package com.example.android.gizatron;

import java.util.Locale;

/** Shared display and status logic for Cairo places, including overnight hours. */
final class OpeningHours {
    private OpeningHours() { }

    static boolean isOpen(float opensAt, float closesAt, float currentTime) {
        if (opensAt == 0f && closesAt == 24f) return true;
        if (closesAt < opensAt) return currentTime >= opensAt || currentTime < closesAt;
        return currentTime >= opensAt && currentTime < closesAt;
    }

    static String formatTime(float time) {
        int totalMinutes = Math.round(time * 60) % (24 * 60);
        int hour = totalMinutes / 60;
        int displayHour = hour % 12;
        if (displayHour == 0) displayHour = 12;
        return String.format(Locale.US, "%d:%02d %s", displayHour, totalMinutes % 60,
                hour >= 12 ? "PM" : "AM");
    }
}
