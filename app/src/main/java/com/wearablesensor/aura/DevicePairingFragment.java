package com.wearablesensor.aura;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wearablesensor.aura.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DevicePairingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DevicePairingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevicePairingFragment extends Fragment {

    private static final String TAG = "DevicePairingFragment";

    @BindView(R.id.device_pairing_image) ImageView mImageView;
    @BindView(R.id.device_pairing_progress_bar) ProgressBar mPropressBar;
    @BindView(R.id.device_pairing_name) TextView mDeviceNameView;
    private OnFragmentInteractionListener mListener;

    public DevicePairingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters
     *
     * @return A new instance of fragment DevicePairingFragment.
     */

    public static DevicePairingFragment newInstance() {
        DevicePairingFragment fragment = new DevicePairingFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_device_pairing, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onDevicePairingFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void displayFailPairing()
    {
        mPropressBar.setVisibility(View.GONE);

        String lNoDevicePairedText = getString(R.string.default_device_name);
        mDeviceNameView.setText( lNoDevicePairedText );

        Drawable failPairingDrawable = ContextCompat.getDrawable(getContext(), R.drawable.link_symbol_2);
        mImageView.setImageDrawable(failPairingDrawable);
        mImageView.setVisibility(View.VISIBLE);
    }

    public void displaySuccessPairing(String iDeviceName, String iDeviceAdress)
    {
        mPropressBar.setVisibility(View.GONE);

        mDeviceNameView.setText(iDeviceName + " - " + iDeviceAdress );

        Drawable successPairingDrawable = ContextCompat.getDrawable(getContext(), R.drawable.link_symbol);
        mImageView.setImageDrawable(successPairingDrawable);
        mImageView.setVisibility(View.VISIBLE);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onDevicePairingFragmentInteraction(Uri uri);
    }
}