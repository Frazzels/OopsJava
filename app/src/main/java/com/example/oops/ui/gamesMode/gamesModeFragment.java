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
    private Button playPicolo;

    private FragmentGamesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gamesModeModel gamesViewModel =
                new ViewModelProvider(this).get(gamesModeModel.class);


        binding = FragmentGamesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDashboard;
        gamesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onClick(View view) {
        Fragment fragment = null;
        switch (view.getId()) {
            case R.id.picoloButton:
                fragment = new PicoloGame();
                replaceFragment(fragment);
                break;
            case R.id.spinButton:
                fragment = new SpinGame();
                replaceFragment(fragment);
                break;
            case R.id.neverButton:
                fragment = new NeverGame();
                replaceFragment(fragment);
                break;
            case R.id.cardButton:
                fragment = new CardGame();
                replaceFragment(fragment);
                break;
        }
    }

    public void replaceFragment(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.nav_games, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}