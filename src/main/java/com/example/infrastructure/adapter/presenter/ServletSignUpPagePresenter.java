package com.example.infrastructure.adapter.presenter;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.example.core.presenter.SignUpPagePresenter;
import com.example.core.usecase.user.GetSignUpPageUsecase.Response;

import lombok.RequiredArgsConstructor;

import static org.springframework.web.context.request.RequestContextHolder.getRequestAttributes;

@Component
@RequiredArgsConstructor
public class ServletSignUpPagePresenter extends SignUpPagePresenter {

    private final ViewResolver viewResolver;

    @Override
    public void present(Response model) {

        final RequestAttributes rawAttributes = getRequestAttributes();

        if (rawAttributes instanceof ServletRequestAttributes) {

            final ServletRequestAttributes attributes = (ServletRequestAttributes) rawAttributes;

            final HttpServletRequest request = attributes.getRequest();
            final HttpServletResponse response = attributes.getResponse();

            if (response != null) try {

                response.setCharacterEncoding("UTF-8");
                response.setStatus(200);
                response.setContentType(MediaType.TEXT_HTML_VALUE);

                final View view =
                viewResolver.resolveViewName("signup", Locale.getDefault());

                if (view != null) {

                    Map<String, String> viewModel = null;

                    if (model!=null && model.getMessage()!=null) {
    
                        viewModel = new HashMap<>();
                        viewModel.put("message", model.getMessage());
                    }
    
                    view.render(viewModel, request, response);
                    response.flushBuffer();
                }

            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
