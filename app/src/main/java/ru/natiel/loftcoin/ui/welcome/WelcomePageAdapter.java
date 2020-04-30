package ru.natiel.loftcoin.ui.welcome;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.natiel.loftcoin.R;
import ru.natiel.loftcoin.databinding.WelcomePageBinding;

class WelcomePageAdapter extends RecyclerView.Adapter<WelcomePageAdapter.ViewHolder> {

    private static final WelcomePageModel[] MODELS = {
            new WelcomePageModel(   R.drawable.welcome_page_1,
                    R.string.welcome_page_1_title,
                    R.string.welcome_page_1_subtitle),
            new WelcomePageModel(   R.drawable.welcome_page_2,
                    R.string.welcome_page_2_title,
                    R.string.welcome_page_2_subtitle),
            new WelcomePageModel(   R.drawable.welcome_page_3,
                    R.string.welcome_page_3_title,
                    R.string.welcome_page_3_subtitle)
    };

    private LayoutInflater inflater;

    @Override
    public int getItemCount() {
        return MODELS.length;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(WelcomePageBinding.inflate(inflater, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.image.setImageResource(MODELS[position].image);
        holder.binding.title.setText(MODELS[position].title);
        holder.binding.subtitle.setText(MODELS[position].subtitle);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        inflater = LayoutInflater.from(recyclerView.getContext());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        final WelcomePageBinding binding;

        public ViewHolder(WelcomePageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    private static class WelcomePageModel {
        int image;
        int title;
        int subtitle;

        public WelcomePageModel(int image, int title, int subtitle) {
            this.image = image;
            this.title = title;
            this.subtitle = subtitle; }

        public int getImage() { return image; }
        public int getTitle() { return title; }
        public int getSubtitle() { return subtitle; }
    }
}
