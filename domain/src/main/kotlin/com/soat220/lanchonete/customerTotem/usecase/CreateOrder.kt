package com.soat220.lanchonete.customerTotem.usecase

import com.soat220.lanchonete.common.exception.DomainException
import com.soat220.lanchonete.common.exception.NotFoundException
import com.soat220.lanchonete.common.model.Order
import com.soat220.lanchonete.common.model.OrderItem
import com.soat220.lanchonete.common.model.Product
import com.soat220.lanchonete.common.model.enums.OrderStatus
import com.soat220.lanchonete.common.result.Result
import com.soat220.lanchonete.common.result.getOrNull
import com.soat220.lanchonete.customerTotem.port.CreateCustomerPort
import com.soat220.lanchonete.customerTotem.port.CreateOrderPort
import com.soat220.lanchonete.customerTotem.port.CreatePaymentPort
import com.soat220.lanchonete.customerTotem.port.FindCustomerByCpfPort
import com.soat220.lanchonete.customerTotem.port.ProcessPaymentPort
import com.soat220.lanchonete.customerTotem.usecase.dto.CreateOrder
import com.soat220.lanchonete.erp.port.FindProductByIdPort
import java.time.LocalDateTime
import javax.inject.Named
import com.soat220.lanchonete.common.model.Customer as DomainCustomer

@Named
class CreateOrder(
    private val findCustomerByCpfPort: FindCustomerByCpfPort,
    private val findProductByIdPort: FindProductByIdPort,
    private val createOrderPort: CreateOrderPort,
    private val createCustomerPort: CreateCustomerPort,
    private val createPaymentPort: CreatePaymentPort,
    private val processPaymentPort: ProcessPaymentPort,
) {
    private fun verifyPayment(orderItems: MutableList<OrderItem>) {
        val totalAmount = orderItems
            .map { it.product.price * it.amount }
            .reduce { acc, price -> acc + price }

//        val paymentStatus =
//            if (processPaymentPort.execute(order, totalAmount)) PaymentStatus.APPROVED
//            else PaymentStatus.DECLINED
//
//        createPaymentPort.execute(order, paymentStatus, totalAmount).orThrow()
//
//        if (paymentStatus != PaymentStatus.APPROVED) {
//            throw PaymentNotApprovedException("Payment not approved", ErrorCode.PAYMENT_NOT_APPROVED)
//        }
    }
}