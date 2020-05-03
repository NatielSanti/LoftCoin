package ru.natiel.loftcoin.ui.wallets;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import lombok.NonNull;
import ru.natiel.loftcoin.R;
import ru.natiel.loftcoin.databinding.FragmentWalletsBinding;

public class WalletsFragment extends Fragment {

    private SnapHelper snapHelper;

    private FragmentWalletsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentWalletsBinding.inflate(inflater, container, false);
        snapHelper = new PagerSnapHelper();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        snapHelper.attachToRecyclerView(binding.recycler);

        TypedValue value = new TypedValue();
        view.getContext().getTheme().resolveAttribute(R.attr.walletCardWidth, value, true);
        final DisplayMetrics dm = view.getContext().getResources().getDisplayMetrics();
        final int padding = (dm.widthPixels - Math.round(value.getDimension(dm))) / 2;
        binding.recycler.setPadding(padding, 0, padding, 0);
        binding.recycler.setClipToPadding(false);

        binding.recycler.addOnScrollListener(new CarouselScroller());

        binding.recycler.setLayoutManager(
                new LinearLayoutManager(view.getContext(), RecyclerView.HORIZONTAL, false));
        binding.recycler.setAdapter(new WalletsAdapter());
        binding.recycler.setVisibility(View.VISIBLE);
        binding.walletCard.setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        snapHelper.attachToRecyclerView(null);
        super.onDestroyView();
    }

    private static class CarouselScroller extends RecyclerView.OnScrollListener{
        @Override
        public void onScrolled(@androidx.annotation.NonNull RecyclerView recyclerView, int dx, int dy) {
            final int centerX = (recyclerView.getLeft() + recyclerView.getRight()) / 2;
            for(int i = 0; i < recyclerView.getChildCount(); i++){
                View child = recyclerView.getChildAt(i);
                int centerChildX = (child.getLeft() + child.getRight()) / 2;
                float childOffset = Math.abs(centerX - centerChildX) / (float)centerX;
                float factor = (float)(Math.pow(0.85, -childOffset));
                child.setScaleX(factor);
                child.setScaleY(factor);
            }
        }
    }
}
