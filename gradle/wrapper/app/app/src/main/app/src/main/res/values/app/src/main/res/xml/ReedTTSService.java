package com.gokul.reedtts;

import android.speech.tts.SynthesisCallback;
import android.speech.tts.SynthesisRequest;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeechService;
import java.util.Locale;

public class ReedTTSService extends TextToSpeechService {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected int onIsLanguageAvailable(String lang, String country, String variant) {
        if (Locale.ENGLISH.getISO3Language().equalsIgnoreCase(lang) ||
            "mar".equalsIgnoreCase(lang) || "mr".equalsIgnoreCase(lang)) {
            return TextToSpeech.LANG_AVAILABLE;
        }
        return TextToSpeech.LANG_NOT_SUPPORTED;
    }

    @Override
    protected String[] onGetLanguage() {
        return new String[] { Locale.ENGLISH.getISO3Language(), Locale.ENGLISH.getISO3Country(), "" };
    }

    @Override
    protected int onLoadLanguage(String lang, String country, String variant) {
        return onIsLanguageAvailable(lang, country, variant);
    }

    @Override
    protected void onStop() {
    }

    @Override
    protected void onSynthesizeText(SynthesisRequest request, SynthesisCallback callback) {
        callback.start(16000, android.media.AudioFormat.ENCODING_PCM_16BIT, 1);
        callback.done();
    }
}

