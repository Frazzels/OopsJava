package com.example.oops.ui.gamesMode;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.oops.ui.gamesMode.picolo.PicoloGame;
import com.example.oops.ui.gamesMode.spintheBottle.SpinGame;
import com.example.oops.ui.gamesMode.neverHaveIEver.NeverGame;
import com.example.oops.ui.gamesMode.HigherOrLower.CardGame;
import com.example.oops.R;
import com.example.oops.databinding.FragmentGamesBinding;

public class gamesModeFragment extends Fragment {

    private FragmentGamesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gamesModeModel gamesViewModel =
                new ViewModelProvider(this).get(gamesModeModel.class);


        View root = inflater.inflate(R.layout.fragment_games, container, false);
        binding = FragmentGamesBinding.inflate(inflater, container, false);

        Button playPicolo = (Button) root.findViewById(R.id.picoloButton);
        Button playSpin = (Button) root.findViewById(R.id.spinButton);
        Button playNever = (Button) root.findViewById(R.id.neverButton);
        Button playCard = (Button) root.findViewById(R.id.cardButton);

        playPicolo.setOnClickListener(view -> {
            Fragment fragment;
            fragment = new PicoloGame();
            replaceFragment(fragment);
        });

        playSpin.setOnClickListener(view -> {
            Fragment fragment;
            fragment = new SpinGame();
            replaceFragment(fragment);
        });

        playNever.setOnClickListener(view -> {
            Fragment fragment;
            fragment = new NeverGame();
            replaceFragment(fragment);
        });

        playCard.setOnClickListener(view -> {
            Fragment fragment;
            fragment = new CardGame();
            replaceFragment(fragment);
        });

        final TextView textView = binding.textDashboard;
        gamesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void replaceFragment(Fragment fragment) {
        assert getFragmentManager() != null;
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_games, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}