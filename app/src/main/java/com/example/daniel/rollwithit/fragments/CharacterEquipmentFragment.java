package com.example.daniel.rollwithit.fragments;

import com.example.daniel.rollwithit.R;
import com.example.daniel.rollwithit.activities.CharacterDisplayActivity;
import com.example.daniel.rollwithit.dndCharacter.Character;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterEquipmentFragment extends Fragment implements View.OnClickListener {

    private static final String TOAST_TEST = "Test Toast";
    private Character character;

    public CharacterEquipmentFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_character_equipment, container, false);
        CharacterDisplayActivity parentActivity = (CharacterDisplayActivity)getActivity();
        character = parentActivity.getCharacter();
        initialiseViews(fragmentView);
        return fragmentView;
    }

    private void initialiseViews(View fragmentView) {
        ArrayAdapter<String> armorListAdapter = new ArrayAdapter<>(getActivity(),
            android.R.layout.simple_expandable_list_item_1, character.getClassType().getArmorProficiencies());
        ListView armorListView = (ListView)fragmentView.findViewById(R.id.armor_proficiency_values);
        armorListView.setAdapter(armorListAdapter);

        ArrayAdapter<String> weaponListAdapter = new ArrayAdapter<>(getActivity(),
            android.R.layout.simple_expandable_list_item_1, character.getClassType().getWeaponProficiencies());
        ListView weaponListView = (ListView)fragmentView.findViewById(R.id.weapon_proficiency_values);
        weaponListView.setAdapter(weaponListAdapter);

        ArrayAdapter<String> toolListAdapter = new ArrayAdapter<>(getActivity(),
            android.R.layout.simple_expandable_list_item_1, character.getClassType().getToolProficiencies());
        ListView toolListView = (ListView)fragmentView.findViewById(R.id.tool_proficiency_values);
        toolListView.setAdapter(toolListAdapter);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), TOAST_TEST, Toast.LENGTH_SHORT).show();
    }
}
