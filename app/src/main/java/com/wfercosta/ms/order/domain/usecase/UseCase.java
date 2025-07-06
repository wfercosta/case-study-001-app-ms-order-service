package com.wfercosta.ms.order.domain.usecase;

public interface UseCase<R, I> {
    R execute(I in);
}