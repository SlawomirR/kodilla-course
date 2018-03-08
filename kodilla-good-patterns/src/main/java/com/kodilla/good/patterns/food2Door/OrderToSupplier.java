package com.kodilla.good.patterns.food2Door;

import lombok.Getter;

import java.util.Map;

@Getter
public class OrderToSupplier {
    private long id;
    private String description;
    private Map<SupplierProduct, Integer> orderList;

    public OrderToSupplier(final long id, final String description, final Map<SupplierProduct, Integer> orderList) {
        this.id = id;
        this.description = description;
        this.orderList = orderList;
    }

    public static final class OrderToSupplierBuilder {
        Map<SupplierProduct, Integer> orderList;
        private long id;
        private String description;

        private OrderToSupplierBuilder() {
        }

        public static OrderToSupplierBuilder aSupplierOrder() {
            return new OrderToSupplierBuilder();
        }

        public OrderToSupplierBuilder withId(long id) {
            this.id = id;
            return this;
        }

        public OrderToSupplierBuilder withDescription(String description) {
            this.description = description;
            return this;
        }

        public OrderToSupplierBuilder withOrderList(Map<SupplierProduct, Integer> orderList) {
            this.orderList = orderList;
            return this;
        }

        public OrderToSupplier build() {
            return new OrderToSupplier(id, description, orderList);
        }
    }
}
