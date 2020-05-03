package ru.natiel.loftcoin.ui.wallets;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.natiel.loftcoin.databinding.LiWalletBinding;

class WalletsAdapter extends RecyclerView.Adapter<WalletsAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        final LiWalletBinding binding;

        ViewHolder(@NonNull LiWalletBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
//            binding.logo.setOutlineProvider(new CircleOutlineProvider());
            binding.logo.setClipToOutline(true);
        }
    }

}
