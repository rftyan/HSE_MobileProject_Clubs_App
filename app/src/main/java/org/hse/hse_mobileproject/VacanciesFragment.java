package org.hse.hse_mobileproject;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class VacanciesFragment extends Fragment {

    public VacanciesFragment() {
        // Пустой конструктор обязателен
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Загрузка макета фрагмента
        View view = inflater.inflate(R.layout.fragment_vacancies, container, false);

        // Настройка элементов интерфейса
        ImageView postImageView = view.findViewById(R.id.post_image);
        TextView postTitleTextView = view.findViewById(R.id.post_title);
        TextView postSubtitleTextView = view.findViewById(R.id.post_subtitle);

        // Здесь вы можете установить текст и изображения по вашему усмотрению

        return view;
    }
}
