package com.example.planland;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.widget.Toast;

import java.util.ArrayList;

import com.example.planland.databinding.FragmentSecondBinding;
import com.example.planland.entities.Box;

//Manage Box
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private RecyclerView boxList;
    private BoxAdapter boxAdapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        //Todo: BOXES
        View v = inflater.inflate(R.layout.fragment_second,container,false);
        boxList = v.findViewById(R.id.recycler_view);
        boxList.hasFixedSize();
        boxList.setLayoutManager(new LinearLayoutManager(getActivity ()));

        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(new Box("Box 1"));
        boxes.add(new Box("Box 2"));
        boxes.add(new Box("Box 3"));

        boxAdapter = new BoxAdapter(boxes);

        boxAdapter.setOnClickListener(box -> {
            Toast.makeText(getActivity(), box.getName(), Toast.LENGTH_SHORT).show();
        });

        boxList.setAdapter(boxAdapter);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}